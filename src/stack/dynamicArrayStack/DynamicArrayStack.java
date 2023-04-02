package stack.dynamicArrayStack;

public class DynamicArrayStack {

    protected int capacity;
    public static final int CAPACITY = 16;
    public static int MINCAPACITY = 1 << 15;
    protected int[] stackRep;
    protected int top = -1;

    public DynamicArrayStack(){
        this(CAPACITY);
    }

    public DynamicArrayStack(int cap){
        capacity = cap;
        stackRep = new int[capacity];
    }

    public int size(){
        return (top + 1);
    }

    public boolean isEmpty(){
        return (top < 0);
    }

    public void push(int data) throws Exception{

        if(size() == capacity){
            expand();
        }
        stackRep[++top] = data;
    }

    private void expand(){
        int length = size();
        int[] newStack = new int[length<<1];
        System.arraycopy(stackRep,0,newStack,0,length);
        stackRep = newStack;
        this.capacity = this.capacity << 1;
    }

    private void shrink() {
        int length = top + 1;
        if(length<=MINCAPACITY || top<<2 >= length)
            return;
        length=length + (top<<1); // still means shrink to at 1/2 or less of the heap if(top<MINCAPACITY) length = MINCAPACITY;
        int[] newstack=new int[length]; System.arraycopy(stackRep,0,newstack,0,top+1);
        stackRep=newstack;
        this.capacity = length;
    }
    public int top() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty.");
        return stackRep[top];
    }
    public int pop() throws Exception {
        int data;
        if (isEmpty())
            throw new Exception("Stack is empty."); data = stackRep[top];
        stackRep[top--] = Integer.MIN_VALUE; // dereference S[top] for garbage collection. shrink();
        return data;
    }
}
