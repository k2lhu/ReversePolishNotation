import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: k2lhu aka rhoads_randy
 * Date: 10.11.13 at 00:25
 * Project name: RPN
 */

public class RPN {
    private MyStack rpnStack;
    private String input;
    private String  output = " ";


    public RPN(String inp) {
        input = inp;
        int stackSize = input.length();
        rpnStack = new MyStack(stackSize);
    }

    public void getOperator(char operatorThis, int priority1){
        while (!rpnStack.isEmpty()) {
            char operatorTop = rpnStack.pop();
            if (operatorTop == '(' ) {
                rpnStack.push(operatorTop);
                break;
            } else {
                int priority2;
                if ( operatorTop == '+' || operatorTop == '-')
                    priority2 = 1;
                else
                    priority2 = 2;
                if (priority2 < priority1) {
                    rpnStack.push(operatorTop);
                    break;
                } else
                    output = output + operatorTop;
            }
        }
        rpnStack.push(operatorThis);
    }

    public String doRPN() {
        for (int i = 0; i<input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    getOperator(ch, 1);
                break;
                case '*':
                case '/':
                    getOperator(ch, 2);
                    break;
                case '(':
                    rpnStack.push(ch);
                    break;
                case ')':
                    getParenthesis(ch);
                    break;
                default:
                    output = output + ch;
                    break;

            }
        }
        while (!rpnStack.isEmpty()) {
            output = output + rpnStack.pop();
        }
        return output;
    }

    public void getParenthesis(char ch) {
        while (!rpnStack.isEmpty() ) {
            char chx = rpnStack.pop();
            if (chx =='(')
                break;
            else
                output = output + chx;
        }
    }

}
