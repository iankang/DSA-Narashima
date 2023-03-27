package CircularLinkedList;

public class CircularLinkedList {

    private CLLNode tail;
    private int length;

    public CircularLinkedList() {
        this.tail = null;
        this.length = 0;
    }

    public void add(int data){
        addToHead(data);
    }

    public void addToHead(int data){

        CLLNode temp = new CLLNode(data);

        if(tail == null){

            this.tail = temp;
            this.tail.setNext(tail);
        } else {
            temp.setNext(tail.getNext());
            tail.setNext(temp);
        }
        length++;
    }

    public void addToTail(int data){

        addToHead(data);
        tail = tail.getNext();
    }

    public int peek(){
        return tail.getNext().getData();
    }

    public int tailPeek(){
        return tail.getData();
    }
}
