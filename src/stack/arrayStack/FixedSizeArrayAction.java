package stack.arrayStack;

public class FixedSizeArrayAction {

    public void action() throws Exception {
        FixedSizeArrayStack fixedSizeArrayStack = new FixedSizeArrayStack(20);

        fixedSizeArrayStack.push(5);
        fixedSizeArrayStack.push(823);
        fixedSizeArrayStack.push(2314);
        fixedSizeArrayStack.push(5823);
        fixedSizeArrayStack.push(3455);
        System.out.println();
        System.out.println();
        System.out.println("Dealing with ArrayStack");
        fixedSizeArrayStack.outputArrayStack("after adding 5 items");
        fixedSizeArrayStack.outputArrayStack("getting the top: "+ fixedSizeArrayStack.top());
        fixedSizeArrayStack.outputArrayStack("popping the stack: "+ fixedSizeArrayStack.pop());
        fixedSizeArrayStack.outputArrayStack("size of the stack: "+ fixedSizeArrayStack.size());
    }
}
