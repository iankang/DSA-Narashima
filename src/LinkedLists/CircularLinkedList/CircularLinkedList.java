package LinkedLists.CircularLinkedList;

import org.w3c.dom.Node;

public class CircularLinkedList {

    private CLLNode head;
    private int length;

    public CircularLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public void addNode(int data){
        CLLNode newNode = new CLLNode(data);
        if(head == null){

            head = newNode;
            newNode.setNext(head);
        } else {
            CLLNode curr = head;
            while(curr.getNext() != head){
                curr = curr.getNext();
            }
            curr.setNext(newNode);
            newNode.setNext(head);

            length++;
        }
    }

    public void removeNode(){
        if(head == null){
            System.out.println("the queue is empty");
            return;
        }

        CLLNode curr = head;
        while (curr.getNext() != head){
            curr = curr.getNext();
        }
        curr.setNext(head.getNext());
        head = head.getNext();
        length--;
    }

    public void removeData(int data){

        CLLNode prev = head;
        CLLNode curr = head.getNext();

        while (curr != head){
            if(curr.getData() == data){
                prev.setNext(curr.getNext());
                length--;
                return;
            }
            prev = curr;
            curr = curr.getNext();
        }
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }


    public void printCircularLinkedList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            CLLNode current = head;
            System.out.print("The circular linked list is as follows: ");
            do {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            } while (current != head && current.getNext() != null);
            System.out.println();
        }
    }
}
