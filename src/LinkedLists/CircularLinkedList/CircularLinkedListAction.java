package LinkedLists.CircularLinkedList;

public class CircularLinkedListAction {

    public void action(){

        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.addNode(123);
        circularLinkedList.addNode(5445);
        circularLinkedList.addNode(345);
        circularLinkedList.addNode(766);
        circularLinkedList.printCircularLinkedList();
        circularLinkedList.removeNode();
        circularLinkedList.printCircularLinkedList();
        circularLinkedList.removeData(766);
        circularLinkedList.printCircularLinkedList();
    }
}
