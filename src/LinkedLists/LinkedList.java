package LinkedLists;

public class LinkedList {

    private int length = 0;
    private ListNode head;

    public LinkedList() {
        this.length = 0;
    }

    public synchronized void insertAtBeginning(ListNode node){

        node.setNext(head);
        head = node;
        length++;
    }

    public synchronized void insertAtEnd(ListNode node){

        if(head == null){
            head = node;
            System.out.println("insertAtEnd: head is null");
        } else {

            ListNode p = head;
            while(p.getNext() != null){

                p = p.getNext();
            }
            p.setNext(node);
            length++;
        }
    }

    public void insert(int data, int position){
        if(position < 0){
            position = 0;
        }

        if(position >length){
            position = length;
        }

        if(head == null){
            head = new ListNode(data);
        } else if (position == 0){

            ListNode temp = new ListNode(data);
            temp.setNext(head);
            head = temp;

        } else {
            ListNode temp = head;
            for(int i = 1; i < position; i++){
                temp = temp.getNext();
            }
            ListNode newNode = new ListNode(data);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        length++;
    }

    public synchronized ListNode removeFromBeginning(){
        ListNode node = head;
        if(node != null){
            head = node.getNext();
            node.setNext(null);
        }
        return node;
    }

    public synchronized ListNode removeFromEnd(){
        if(head == null){
            return null;
        }

        ListNode p = head, q  = null, next = head.getNext();
        if(next == null){
            head = null;
            return p;
        }

        while((next = p.getNext())!= null){
            q = p;
            p = next;
        }

        q.setNext(null);
        return p;
    }

    public synchronized void removeMatched(ListNode node){
        if(head == null){
            return;
        }
        if(node.equals(head)){
            head = head.getNext();
            return;
        }

        ListNode p = head, q = null;
        while ((q = p.getNext()) != null){
            if(node.equals(q)){
                p.setNext(q.getNext());
                return;
            }
            p = q;
        }
    }

    public void remove(int position){
        if(position < 0){
            position = 0;
        }

        if(position >= length){
            position = length - 1;
        }

        if(head == null){
            return;
        }
        if(position == 0){
            head = head.getNext();
        }
        else {
            ListNode temp = head;
            for(int i = 1; i < position; i++){
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        length -=1;
    }

    public String toString(){
        String result = "[";
        if(head == null){
            return result +"]";
        }
        result = result+head.getData();
        ListNode temp = head.getNext();

        while(temp != null){
            result = result + ","+ temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }

    public int length(){
        return length;
    }

    public int getPosition(int data){

        ListNode temp = head;
        int pos = 0;

        while (temp != null){
            if(temp.getData() == data){
                return pos;
            }
            pos++;
            temp = temp.getNext();
        }
        return Integer.MIN_VALUE;
    }

    public void clearList(){
        head = null;
        length = 0;
    }
}
