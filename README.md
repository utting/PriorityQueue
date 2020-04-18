  # PriorityQueue
  A PriorityQueue implementation in java with minimum heap

  Data structures is a very important concept in software development and computer science in general. There are several data structures and one of them is Queue. A queue is a data structure that holds data in order of insertion and provides a method of accessing data in first-in, first-out order (FIFO) - now you can tell why British English Speakers say "queue" rather than "line". In other words, items in a queue can only be accessed in order of insertion with those inserted first being accessed before those inserted last. The most useful operations on a queue are usually adding an item to the top of the queue (enqueue), removing an item from the top of the queue(dequeue) and accessing the top element of the queue without removing it 
(peek).

  While queues are useful in many cases, there are times that we rather want a special version of queue where we assign priority to each item in the queue and items with lower priority are accessed before those with higher priority. For instance, in a hospital, because some patients have more urgent and critical injuries than others, we don't always want those who came first to necessarely be seen before those who came after them. We want those with more alarming illness to receive care before those with less alarming illness. As each new patient checks in at the hospital, the staff assesses their injuries and gives that patient an integer priority rating, with smaller integers representing greater urgency. (For example, a patient of priority 1 is more urgent and should receive care before a patient of priority 2.)

  Once a doctor is ready to see a patient, the patient with the most urgent (smallest) priority is seen first. That is, regardless of the order in which you add/enqueue the elements, when you remove/dequeue them, the one with the most urgent priority (smallest integer value) comes out first, then the second-smallest, and so on, with the least urgent priority (largest integer value) item coming out last. A queue that processes its elements in order of increasing
priority like this is also called a priority queue.

  For a binary minimum heap, the element with the minimum priority value is frontmost.
That is, regardless of the order in which you add/enqueue the elements, the minimum priority
element is dequeued first, then the second-smallest, and so on, with the largest priority
element coming out last.

  For example, if the following patients arrive at the hospital in this order and the priority
they are assigned is shown in parentheses:
  -”Anat” (4)
  
  - ”Ben” (9)
  
  - ”Sasha” (8)
  
  - ”Wu” (7)

  - Rein” (6)

  - ”Ford” (2)
  
  If you were to place them into a patient queue and dequeue them, they would come out in
this order:

  - Ford, Anat, Rein, Wu, Sasha, Ben
  
  
  #Binary Heap
  
The patient queue is a specific application of a well-known abstract data type called a priority
queue. You can think of a priority queue as a sorted queue where the elements are sorted
by priority. But the priority queue need not internally store its elements in sorted order; all
that matters is that the dequeue operation accesses the frontmost element (which will be the
minimum priority). As we will see, this difference between the external expected behavior of
the priority queue and its true internal state can lead to an interesting implementation.

The priority queue implementation we are to write stores the elements into an unfilled
array. The array elements are organized into an arrangement called a binary heap. A binary
heap that is arranged to put the minimum priority element frontmost is classified as a minimun heap.

A binary heap is an array that obeys a heap ordering property. Each index i is thought of as the ”parent” of the two ”child” indexes, i * 2 and i * 2 + 1. (To simplify the index math, we leave index 0 unused and starting the data
at index 1.) A parent is always in front of its children in the queue. For a min-heap, this means the parent must have a smaller priority than its children, i.e. it is the minimum of the ”family”.

One very desirable feature of a binary heap is that the frontmost element (the one that should be returned by peek or dequeue) is always located at index 1. When inserting an item, we always need to make sure the elements in the queue follow minum head
- that is a parent (item at index i) is always in front of its children (item at index i*2 and i*2 + 1). For that matter, we always just need to dequeue (remove) the first element. This way, we don't need to worry about sorting the queue in order of priority. All we need to worry about is the minimun heap order is mantained at all times. 


#Dequeue

Removing (dequeuing) an element from a heap is done by replacing the element at index 1
with the element from the last occupied index of the array and then ”bubbling down” that
element to the proper position according to heap order. Effectively, this takes an element that
was formerly near the ”back” of the queue, temporarily puts it in the very front, and then
sinks it backward to the proper place by moving it behind its children where appropriate.

Heap order for a min-heap dictates that a parent must be the minimum of the family. If
a parent is larger than either/both children, it belongs behind it, so the smaller of the two
children must be swapped with the parent. If after swapping, the element that moved behind is still larger than either/both children, it must swap again. The element continues swapping toward the back until it settles in the proper position and heap order has been restored.


#Change Priority

To change the priority of an existing element in a binary heap, you must first loop over the
entire heap to find the element. Once found, you set its new priority and then ”bubble” the
element forward or backward from its current position to restore heap order. Bubbling foward (up) here
means moving a given elements to lower indexes, and bubbling backwards (down) means switching the elements position to a greater index. Thus, if an element's priority is changed to a greater priority, then compare its priority with its most urgent child (the child with the lower priority between the two children). If the new parent priority is greater than the priority of its most urgent child, then we swap the parent's position with that of its most urgent child and we keep doing that until the parent priority is no longer larger than its current most urgent child. On the other hand, if an item priority is changed to a lower priority than its previous priority, then we need to compare it to the priority of its parent. If the item priority is lower than its parent's priority, then we swap its position with that of its parent and repeat the process until its new priority is no longer lowe than its new subsequent parent.

Doing that will ensure that minimun heap order is always maintained, which is the goal of our priority queue. Now that we understand what to do, we can now implement the priority queue. Take a look at the source files to understand how I implemented the priority queue. Notice that the only files you really need is the PatientQueue.java, which holds the queue of Patient objects, and the Patient.java class, which holds the class Patient. The PatientQueueTestClass.java is the unit test file used to test the Queue implementation.

If you find this repo useful to you, feel free to modify and or use it directly in your projects. Also, please, share this with other who might find it useful.

Note: Most of this readMe description comes from a program assignment description for an assigment I did in my last year of computer science minor with few modifications and additions included. All the code was implement by me. 

#Created with love by Emanuel Inacio




