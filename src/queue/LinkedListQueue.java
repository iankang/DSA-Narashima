package queue;

import LinkedLists.ListNode;

public class LinkedListQueue {

    private int length;
    private ListNode front, rear;

    public LinkedListQueue() {
        length = 0;
        front = rear = null;
    }

    public void enqueue(int data){
        ListNode node = new ListNode(data);
        if(isEmpty()){
            front = node;
        } else {
            rear.setNext(node);
        }
        rear = node;
        length++;
    }

    public int first() throws Exception{
        if(isEmpty()){
            throw new Exception();
        }
        return front.getData();
    }

    public int dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("queue");
        }
        int result = front.getData();
        front = front.getNext();
        length--;
        if(isEmpty()){
            rear = null;
        }
        return result;
    }

    public boolean isEmpty(){
        return (length == 0);
    }

    public int size(){
        return length;
    }

    public String toString(){
        String result = "";
        ListNode current = front;
        while (current != null){
            result += result+ current.toString()+ "\n";
            current = current.getNext();
        }
        return result;
    }
}
