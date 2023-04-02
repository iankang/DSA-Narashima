package stack.linkedListStack;

public class LinkedStackAction {

    public void showLinkedStackInAction(){
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(1);
        linkedStack.push(2341);
        linkedStack.push(1464);
        linkedStack.push(18345923);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("look at the linked stack");
        linkedStack.PrintOut();

        System.out.println("peeking, we see: "+linkedStack.peek());

        System.out.println("when we pop: "+ linkedStack.pop());
        linkedStack.PrintOut();
    }

}
