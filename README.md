  # PriorityQueue
  A PriorityQueue implementation in java with a binary minimum heap

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
  
For more detailed information about how this priority queue was implemented, please read PA9.pdf in the repo folder.

If you find this repo useful to you, feel free to modify and or use it directly in your projects. Also, please, share this with other who might find it useful.

Note: Most of this readMe description comes from a program assignment description for an assigment I did in my last year of computer science minor with few modifications and additions included. All the code was implement by me. 

  # Created with love by Emanuel Inacio




