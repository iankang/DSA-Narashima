package queue;

public class ArrayQueueAction {

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue();
        aq.enqueue(4);
        System.out.println("Enqueue element "+aq.toString());
        System.out.println("Deque element "+aq.dequeue());

        aq.enqueue(56);
        aq.enqueue(2);
        aq.enqueue(67);

        System.out.println("Queue elements: "+ aq.toString());
        System.out.println("Deque element "+aq.dequeue());
        System.out.println("Deque element "+aq.dequeue());

        aq.enqueue(24);
        System.out.println("Queue element: "+ aq.toString());
        aq.enqueue(98);
        aq.enqueue(45);
        aq.enqueue(23);
        aq.enqueue(435);

        System.out.println("Queue elements: "+ aq.toString());
    }
}
