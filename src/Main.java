import LinkedLists.LinkedList;
import LinkedLists.ListNode;
import doublyLinkedLists.DoublyLinkedList;
import recursion.ArrayIsSorted;
import recursion.TowerOfHanoi;

public class Main {
    public static void main(String[] args) {

        TowerOfHanoi tower = new TowerOfHanoi();
        tower.hanoiTower(3,'A','C','B');

        System.out.println();
        System.out.println();

        ArrayIsSorted isSorted = new ArrayIsSorted();
        System.out.println(isSorted.isArraySorted(new int[]{1, 2, 3, 4, 5, 6},6));
        System.out.println(isSorted.isArraySorted(new int[]{1, 2, 3, 5, 4, 6},6));

        System.out.println();
        System.out.println();

         LinkedList linkedList = new LinkedList();
         ListNode first = new ListNode(105);
         ListNode sekend = new ListNode(106);
         ListNode third = new ListNode(107);
         ListNode fourth = new ListNode(108);
         ListNode fifth = new ListNode(109);
         ListNode sixth = new ListNode(110);
         ListNode seventh = new ListNode(111);
         ListNode eighth = new ListNode(112);
         ListNode ninth = new ListNode(113);
         ListNode tenth = new ListNode(114);

         linkedList.insertAtBeginning(first);
         linkedList.insertAtEnd(sekend);
         linkedList.insertAtEnd(third);
         linkedList.insertAtEnd(fourth);
         linkedList.insertAtEnd(fifth);
         linkedList.insertAtEnd(sixth);
         linkedList.insertAtEnd(seventh);
         linkedList.insertAtEnd(eighth);
         linkedList.insertAtEnd(ninth);
         linkedList.insertAtEnd(tenth);

         linkedList.insert(1150,4);

         System.out.println(linkedList.toString());
         System.out.printf("The length is %d %n", linkedList.length());
         System.out.printf("The position of 1150 is %d %n",linkedList.getPosition(1150));
         System.out.printf("The position of 114 is %d %n",linkedList.getPosition(114));
         linkedList.removeFromBeginning();
         System.out.println("After removing from beginning: "+ linkedList.toString());
         linkedList.removeFromEnd();
         System.out.println("After removing from end: "+ linkedList.toString());
         linkedList.remove(2);
         System.out.println("After removing from position 2: "+ linkedList.toString());
         linkedList.removeMatched(seventh);
         System.out.println("After removing matching node number 7: "+ linkedList.toString());
         linkedList.clearList();
         System.out.println("After clearing list: "+ linkedList.toString());

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertTail(42);
        dll.insertTail(420);
        dll.insertTail(4123);
        dll.insertTail(134);
        dll.insertTail(345);
        dll.insertTail(6543);
        dll.insertTail(34);
        dll.insertTail(57);
        System.out.println("added some elements "+dll.toString());

        System.out.println("getting at position 2: "+ dll.get(2));
        dll.insert(52);
        System.out.println("Inserting a random number "+ dll.toString());
        dll.insert(566,5);
        System.out.println("Inserting a random number at position 3 "+ dll.toString());
        dll.customMessage("remove the head "+dll.removeHead());
        dll.customMessage("remove the tail " + dll.removeTail());
        dll.customMessage("get data position  " + dll.getPosition(345));
        dll.remove(6);
        dll.customMessage("remove item at position 6");
    }
}
