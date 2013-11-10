/**
 * Created with IntelliJ IDEA.
 * User: k2lhu aka rhoads_randy
 * Date: 10.11.13 at 00:25
 * Project name: RPN
 */

public class MyStack {

    private int size;
    private char[] stackArray;
    private int top;


    public MyStack(int s) {
        size = s;
        stackArray = new char[size];
        top = -1;
    }

    public int size() {
        return top+1;
    }

    public void push(char item) {
        stackArray[++top] = item;
    }

    public char pop() {
        if(isEmpty())
        {
            throw new NullPointerException("There are no elements in the stack");
        }
        return stackArray[top--];
    }

    public void displayStack(String s) {
        System.out.print(s);
        for(int i=0; i<size(); i++)
        {
            System.out.print( peekN(i) );
            System.out.print(' ');
        }
        System.out.println("");
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //  Return item at index i
    public char peekN(int i) {
        return stackArray[i];
    }

}
