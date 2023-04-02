package stack.linkedListStack;

import LinkedLists.ListNode;

import java.util.EmptyStackException;

public class LinkedStack {
    private int length;
    private ListNode top;

    public LinkedStack() {
        length = 0;
        top = null;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public int pop() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int result = top.getData();
        top = top.getNext();
        length--;
        return result;
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.setNext(top);
        top = temp;
        length++;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.getData();
    }

    public int size(){
        return length;
    }

    public String toString(){
        String result = "";
        ListNode current = top;
        while (current != null){
            result = result + current.toString() + "\n";
            current = current.getNext();
        }
        return result;
    }

    public void PrintOut(){
        System.out.println("the linked stack is: "+ this.toString());
    }
}
