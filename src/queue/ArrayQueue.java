package queue;

public class ArrayQueue {

    private int[] A;
    private int size, front, rear;
    private static final int CAPACITY = 16;

    public ArrayQueue(){
        A = new int[CAPACITY];
        size = 0;
        front = 0;
        rear = 0;
    }

    public ArrayQueue(int cap){
        A = new int[cap];
        size = 0;
        front = 0;
        rear = 0 ;
    }

    public void enqueue(int data){
        if(size == CAPACITY){
            throw new IllegalStateException("Queue is full: Overflow");
        } else {
            size++;
            A[rear] = data;
            rear = (rear + 1)%CAPACITY;
            System.out.println("enqueue: "+ data);
            System.out.println("rear: "+ rear);
            System.out.println("size: "+ size);
        }
    }

    public int dequeue() throws IllegalStateException{
        if(size == 0){
            throw new IllegalStateException("Queue is empty: Underflow");
        } else {
            size--;
            int data = A[front % CAPACITY];
            A[front] = Integer.MIN_VALUE;
            front = (front + 1) % CAPACITY;
            System.out.println("dequeue: "+ data);
            System.out.println("front: "+ front);
            return data;
        }
    }

    public boolean isEmpty(){
        return (size == 0);
    }
    public boolean isFull(){
        return (size == CAPACITY);
    }

    public String toString(){
        StringBuilder result = new StringBuilder("[");
        for(int i = 0; i < size; i++){
            result.append(Integer.toString(A[i]));
            result.append(",");
        }
        result.append("]");
        return result.toString();
    }
}
