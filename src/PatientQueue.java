/*
 * Programmer: Emanuel Inacio
 *
 * File: PatientQueue.java
 *
 * Purpose: This file implements a priority queue of patient objects using a minimun
 * binary heep. That is the elements are dequeued based on priority rather than
 * position in the queue. Elements with smaller priorities are dequeued first.
 *
 * Usage: This class requires a Patient class that has two member variables:
 *
 * name: the name of the patient
 * priority: the priority of the patient in the queue.
 *
 * Node: the Patient class needs to be in the same package as PatientQueue class.
 *
 *
 */

public class PatientQueue {

    private int capacity;
    private int size;
    private Patient[] queue;


    public PatientQueue(){
        size = 0;
        capacity = 4;
        queue = new Patient[capacity];

    }


    /*
     * adds the given person into your patient queue with the given priority and
     * ”bubbles up” appropriately to keep the array in proper heap order.
     * Duplicate names and priorities are allowed and should be added just like
     * any other value. Any string is a legal value and any integer is a
     * legal priority. If there is no room in the queue’s internal array,
     * the array is resized to a larger array with twice the capacity.
     *
     * @params name: the patient's name
     * @params priority: the patient's priority
     *
     * @return void
     */
    public void enqueue(String name, int priority){

        // Create patient object
        Patient patient = new Patient(name, priority);

        // Add the new patient to the queue
        this.enqueue(patient);

    }


    /*
     * This function is the same as the above function but takes in a
     * Patient object directly instead of a name and priority.
     *
     * @param patient: a object representing a patient
     *
     * @return void
     */
    public void enqueue(Patient patient) {

        // if array is full, doubles the size
        if (size + 1 >= capacity) {
            capacity = capacity * 2;
            this.grow_helper();
        }

        // Add the element
        queue[size + 1] = patient;

        // Move "bubble" the patient at position (size + 1) backwards if needed
        bubbleUp(size + 1);
        size++;
    }


    /*
     * Swaps patient at position index with its parent (patient at position index/2 )
     * until heap ordering is satisfied
     *
     * @param index: the index of the element to check against the array
     *
     * @return void
     */
    private void bubbleUp(int index) {
        int childIndex = index;
        int parentIndex = childIndex / 2;

        // bubble up until heap order is satisfied or until the current index is 1
        while (parentIndex >= 1) {

            if (queue[childIndex].priority <  queue[parentIndex].priority) {
                swapPatients(queue[childIndex], queue[parentIndex], childIndex, parentIndex);
            }else if (queue[childIndex].priority ==  queue[parentIndex].priority){
                String child = queue[childIndex].name;
                String parent = queue[parentIndex].name;

                if ( this.childIsSmaller(child, parent )) {

                    // bubble the patient up bu swapping the position of the two patients
                    swapPatients(queue[childIndex], queue[parentIndex], childIndex, parentIndex);
                }
            }else {
                break;
            }
            childIndex = parentIndex;
            parentIndex = childIndex / 2;
        }
    }

    /*
     * Swap the patient at position parentIndex downwards (to the right) with its
     * most urgent child (the child with smaller priority) until
     * head ordering is satisfied
     *
     * @param parentIndex: the index of the element to check against the array
     *
     * @return void
     */
    private void bubbleDown(int parentIndex) {
        int firstChildIndex = parentIndex * 2;
        int secondChildIndex = (parentIndex * 2) + 1;
        int childIndex;

        // Find the most urgent child
        if (firstChildIndex > size) return;
        else if (firstChildIndex == size) childIndex = firstChildIndex;
        else {
            if (queue[firstChildIndex].priority < queue[secondChildIndex].priority) {
                childIndex = firstChildIndex;
            }else if (queue[firstChildIndex].priority > queue[secondChildIndex].priority){
                childIndex = secondChildIndex;
            }else {
                childIndex = firstChildIndex;
            }
        }

        // Bubble down the queue based on whether the parent priority is less than the child
        if (queue[childIndex].priority <  queue[parentIndex].priority) {
            swapPatients(queue[childIndex], queue[parentIndex], childIndex, parentIndex);
            bubbleDown(childIndex); // recursively bubbleDown
        }else if (queue[childIndex].priority ==  queue[parentIndex].priority){
            String child = queue[childIndex].name;
            String parent = queue[parentIndex].name;

            if ( this.childIsSmaller(child, parent )) {
                swapPatients(queue[childIndex], queue[parentIndex], childIndex, parentIndex);
                bubbleDown(childIndex); // recursively bubbleDown
            }
        }
    }


    /*
     * Swaps two patients where child is patient at position index/2
     * and parent is at position index.
     *
     * @param child: the patient at position index/2
     * @param patent: the patient at position index
     *
     * @return void
     */
    private void swapPatients(Patient child, Patient parent, int index1, int index2) {
        queue[index2] = child;
        queue[index1] = parent;
    }


    /*
     * Given two strings, checks if the first passed-in string
     * is smaller than the second one. We compare each character
     * of both strings until we find the smaller character.
     *
     * @param child: the name of the patient at position index/2
     * @param patent: the name of the patient at position index
     *
     * @return true/false: true if child's name is smaller than parent's name
     */
    private boolean childIsSmaller(String child, String parent){

        // Base case
        if (child.isEmpty()) return true;
        else if (parent.isEmpty()) return false;

        // Recursive Case
        if (child.charAt(0) < parent.charAt(0)){
            return true;
        }else if (child.charAt(0) > parent.charAt(0)) {
            return false;
        }else {
            return childIsSmaller(child.substring(1), parent.substring(2));
        }

    }



    /*
     * Grows the array and copy the elements from old to new array
     *
     * @param none
     *
     * @return void
     */
    private void grow_helper(){
        Patient[] newQueue = new Patient[capacity];

        for (int i = 1; i < size + 1; i++){
            newQueue[i] = queue[i];
        }
        queue = newQueue;
    }


    /*
     * Removes the front most patient in your queue, and return their name as a string.
     * Throws an exception if the queue is empty.
     *
     * @params none
     *
     * @return name: the patient's name
     */
    public String dequeue() {

        // Throws an exception if queue is empty
        if (size == 0) {
            throw new NullPointerException("Cannot dequeue empty queue");
        }

        String name = queue[1].name;
        queue[1] = queue[size];
        size--;
        bubbleDown(1);

        return name;
    }


    /*
     * Returns the name of the front most patient
     * in the queue, without removing or altering the state of the
     * queue. Throws an exception if the queue is empty.
     *
     * @params none
     *
     * @return name: the patient's name
     */
    public String peek() {
        // Throws an exception if queue is empty
        if (size == 0) {
            throw new NullPointerException("Cannot dequeue empty queue");
        }

        return queue[1].name;
    }


    /*
     * returns the integer priority of the front most patient in the queue
     * without removing it or altering the state of the queue.
     * Throws an exception if the queue is empty.
     *
     * @param none
     *
     * @return priority: the priority of the front most patient in the queue
     */
    public int peekPriority() {
        // Throws an exception if queue is empty
        if (size == 0) {
            throw new NullPointerException("Cannot dequeue empty queue");
        }

        return queue[1].priority;
    }


    /*
     * Modifies the priority of a given existing patient in the queue.
     * Since this queue uses in a min-heap, changing to a smaller integer
     * priority value might cause the patient to move frontward ahead
     * of others in the queue, or changing to a larger integer priority
     * might cause the patient to move backward behind others. A request
     * to change a patient’s priority to the same value it already has should
     * have no effect on the queue. If the given patient name occurs multiple
     * times in the queue, you should alter the priority of the first occurrence
     * you find when searching your array from the start index.
     * If the given name is not in the queue, nothing should happen.
     *
     * @param name: the name of the patient
     * @param newPriority: the priority to be changed to
     *
     * @return void
     */
    public void changePriority(String name, int newPriority){

        for (int i = 1; i < size + 1; i++){
            Patient patient = queue[i];

            if ( patient.name.equals(name) ) {
                int oldPriority = patient.priority;
                patient.priority = newPriority; // sets the new priority

                if (newPriority < oldPriority){
                    bubbleUp(i);
                }else if (newPriority > oldPriority){
                    bubbleDown(i);
                }
            }

        }

    }


    /*
     * Returns true if your patient queue does not contain any elements
     * and false if it does contain at least one patient.
     *
     * @param none
     *
     * @return true/false: true if queue is not empty. False, otherwise.
     */
    public boolean isEmpty() {

        return size == 0;
    }


    /*
     * return the number of elements in the patient queue.
     *
     * @param none
     *
     * @return size: the number of patients in queue
     */
    public int size() {

        return size;
    }


    /*
     * Removes all elements from your patient queue.
     */
    public void clear() {
        size = 0;
        capacity = 10;
        queue = new Patient[capacity];
    }


    /*
     * Returns a string representation of the queue in the following format:
     * {Anat (4), Rein (6), Sasha (8), Ben (9), Wu (7), Eve (10)}
     *
     * @param none
     *
     * @return str: a string representing the queue
     */
    public String toString() {

            StringBuilder builder = new StringBuilder();
            builder.append("{");
            for (int i = 0; i < size + 1; i++){

                if (i == 0) continue;
                else if (i != 1) builder.append(" ");

                builder.append(queue[i].name);
                builder.append(" (");
                builder.append(queue[i].priority);
                builder.append(")");

                if (i < size) builder.append(",");
            }
            builder.append("}");

        return builder.toString();
    }
}
