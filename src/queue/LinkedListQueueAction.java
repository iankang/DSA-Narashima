package queue;

public class LinkedListQueueAction {

    public static void main(String[] args) throws Exception {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        System.out.println("enqueue 5");
        linkedListQueue.enqueue(5);
        System.out.println("enqueue 8");
        linkedListQueue.enqueue(8);
        System.out.println("enqueue 10");
        linkedListQueue.enqueue(10);
        System.out.println("enqueue 231");
        linkedListQueue.enqueue(231);
        System.out.println("enqueue 8273");
        linkedListQueue.enqueue(8273);

        System.out.println("dequeue: "+ Integer.toString(linkedListQueue.dequeue()));
        System.out.println("dequeue: "+ Integer.toString(linkedListQueue.dequeue()));
        System.out.println("dequeue: "+ Integer.toString(linkedListQueue.dequeue()));


    }
}
