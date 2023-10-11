package priqueue;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PatientQueueTest {

    /*
     *  Tests enqueue when there are no elements with same priority
     */
    @Test
    public void enqueue_test_1(){

        // {Anat (4), Rein (6), Sasha (8), Ben (9), Wu (7), Eve (10)}
        PatientQueue queue = new PatientQueue();
        List<String> names = new ArrayList<>(Arrays.asList("Anat", "Ben", "Sasha", "Wu", "Rein", "Ford", "Eve"));
        List<Integer> priorities = new ArrayList<>(Arrays.asList(4, 9, 8, 7, 6, 2, 3));

        for (int i = 0; i < 7; i++){
            queue.enqueue(names.get(i), priorities.get(i));
        }

        assertEquals("{Ford (2), Rein (6), Eve (3), Ben (9), Wu (7), Sasha (8), Anat (4)}", queue.toString());
        System.out.println("enqueue(name, priority), got " + queue.toString());

    }


    /*
     *  Tests enqueue when there are elements with same priority
     */
    @Test
    public void enqueue_test_2(){

        // {Anat (4), Rein (6), Sasha (8), Ben (9), Wu (7), Eve (10)}
        PatientQueue queue = new PatientQueue();
        List<String> names = new ArrayList<>(Arrays.asList("Anat", "Ben", "Sasha", "Wu", "Rein", "Ford", "Eve", "Dean"));
        List<Integer> priorities = new ArrayList<>(Arrays.asList(4, 9, 8, 7, 6, 2, 3, 2));

        for (int i = 0; i < 8; i++){
            queue.enqueue(names.get(i), priorities.get(i));
        }

        assertEquals("{Dean (2), Ford (2), Eve (3), Rein (6), Wu (7), Sasha (8), Anat (4), Ben (9)}", queue.toString());
        System.out.println("enqueue(name, priority), got " + queue.toString());
    }

    /*
     * Tests dequeue method
     */
    @Test
    public void dequeue_test_1(){

        // {Anat (4), Rein (6), Sasha (8), Ben (9), Wu (7), Eve (10)}
        PatientQueue queue = new PatientQueue();
        List<String> names = new ArrayList<>(Arrays.asList("Anat", "Ben", "Sasha", "Wu", "Rein", "Ford", "Eve"));
        List<Integer> priorities = new ArrayList<>(Arrays.asList(4, 9, 8, 7, 6, 2, 3));

        for (int i = 0; i < 7; i++){
            queue.enqueue(names.get(i), priorities.get(i));
        }

        // .... Rein (6), Eve (3), Ben (9), Wu (7), Sasha (8), Anat (4)

        //Eve (3), Rein (6), Anat (4), Ben (9), Wu (7), Sasha (8)}

        String result = queue.dequeue();
        assertEquals("Ford", result);

        // Expected order after removal
        // Ford (2), Rain (6), Eve (3), Ben (9), Wu (7), Sasha (8), Anat (4)
        assertEquals("{Eve (3), Rein (6), Anat (4), Ben (9), Wu (7), Sasha (8)}", queue.toString());
        System.out.println("dequeue(), got " + queue.toString());

    }

    /*
     * Tests dequeue method
     */
    @Test
    public void dequeue_test_2(){

        // {Anat (4), Rein (6), Sasha (8), Ben (9), Wu (7), Eve (10)}
        PatientQueue queue = new PatientQueue();
        List<String> names = new ArrayList<>(Arrays.asList("Anat", "Ben", "Sasha", "Wu", "Rein", "Ford", "Eve"));
        List<Integer> priorities = new ArrayList<>(Arrays.asList(4, 9, 8, 7, 6, 2, 3));

        for (int i = 0; i < 7; i++){
            queue.enqueue(names.get(i), priorities.get(i));
        }

        names = new ArrayList<>();
        while ( !queue.isEmpty()){
            names.add(queue.dequeue());
        }

        // "{Ford (2), Rein (6), Eve (3), Ben (9), Wu (7), Sasha (8), Anat (4)}"
        assertEquals( "[Ford, Eve, Anat, Rein, Wu, Sasha, Ben]", names.toString());
        System.out.println("dequeue(), got " + queue.toString());

    }

    /*
     * Test dequeue when attempting to dequeue an empty string
     */
    @Ignore
    @Test
    public void dequeue_test_3() {
        // {Anat (4), Rein (6), Sasha (8), Ben (9), Wu (7), Eve (10)}
        PatientQueue queue = new PatientQueue();

        String result = queue.dequeue();
        assertEquals("Ney", result);
        System.out.println("dequeue(), got " + result);
    }

    /*
     * Tests dequeue for a regular case with o one-patient queue
     */
    @Test
    public void dequeue_test_4(){
        PatientQueue queue = new PatientQueue();
        queue.enqueue("Ney", 3);

        String result = queue.dequeue();
        assertEquals("Ney", result);
        System.out.println("dequeue(), got " + result);
    }



    /*
     * Tests change priority
     */
    @Ignore(value="leave this untested for now")
    @Test
    public void changePriority_test_1(){
        // {Anat (4), Rein (6), Sasha (8), Ben (9), Wu (7), Eve (10)}
        PatientQueue queue = new PatientQueue();
        List<String> names = new ArrayList<>(Arrays.asList("Anat", "Ben", "Sasha", "Wu", "Rein", "Ford", "Eve"));
        List<Integer> priorities = new ArrayList<>(Arrays.asList(4, 9, 8, 7, 6, 2, 3));

        for (int i = 0; i < 7; i++){
            queue.enqueue(names.get(i), priorities.get(i));
        }

        // Ford (2), Rein (6), Eve (3), Ben (9), Wu (7), Sasha (8), Anat (4)

        queue.changePriority("Ford", 10);
        assertEquals("{Eve (3), Rein (6), Anat (4), Ben (9), Wu (7), Sasha (8), Ford (10)}", queue.toString());
        System.out.println("changePriority(Ford, 10), got " + queue.toString());

    }


    @Test
    public void peek_test_1(){
        // {Anat (4), Rein (6), Sasha (8), Ben (9), Wu (7), Eve (10)}
        PatientQueue queue = new PatientQueue();
        List<String> names = new ArrayList<>(Arrays.asList("Anat", "Ben", "Sasha", "Wu", "Rein", "Ford", "Eve"));
        List<Integer> priorities = new ArrayList<>(Arrays.asList(4, 9, 8, 7, 6, 2, 3));

        for (int i = 0; i < 7; i++){
            queue.enqueue(names.get(i), priorities.get(i));
        }

        String name = queue.peek();

        // Ford (2), Rein (6), Eve (3), Ben (9), Wu (7), Sasha (8), Anat (4)
        assertEquals("Ford",  name);
        assertEquals("{Ford (2), Rein (6), Eve (3), Ben (9), Wu (7), Sasha (8), Anat (4)}", queue.toString());
        System.out.println("peek(), got " + name);
    }

    @Test
    public void peekPriority_test_1(){
        // {Anat (4), Rein (6), Sasha (8), Ben (9), Wu (7), Eve (10)}
        PatientQueue queue = new PatientQueue();
        List<String> names = new ArrayList<>(Arrays.asList("Anat", "Ben", "Sasha", "Wu", "Rein", "Ford", "Eve"));
        List<Integer> priorities = new ArrayList<>(Arrays.asList(4, 9, 8, 7, 6, 2, 3));

        for (int i = 0; i < 7; i++){
            queue.enqueue(names.get(i), priorities.get(i));
        }

        int priority = queue.peekPriority();

        // Ford (2), Rein (6), Eve (3), Ben (9), Wu (7), Sasha (8), Anat (4)
        assertEquals(2,  priority);
        assertEquals("{Ford (2), Rein (6), Eve (3), Ben (9), Wu (7), Sasha (8), Anat (4)}", queue.toString());
        System.out.println("peekPriority(), got " + priority);
    }




}
