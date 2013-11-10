/**
 * Created with IntelliJ IDEA.
 * User: k2lhu aka rhoads_randy
 * Date: 10.11.13 at 13:14
 * Project name: RPN
 */
import java.io.*;

public class App {

    public static  String readString() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String s = br.readLine();
        return s;
    }

    public static void main(String[] args) throws IOException {
        String input;
        String output;
        while (true) {
            System.out.print("Enter the: ");
            System.out.flush();
            input = readString();
            if (input.equals(""))
                break;
            RPN rpnTrans = new RPN(input);
            output = rpnTrans.doRPN();
            System.out.println("Here we go: "+output+'\n');
            break;
        }
    }

}
