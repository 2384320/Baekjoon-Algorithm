import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;

        while (!(str = br.readLine()).equals(".")) {
            bw.write(parenthesis(str) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    public static String parenthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '[') stack.add(ch);
            else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return "no";
                else stack.pop();
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return "no";
                else stack.pop();
            }
        }
        if (stack.isEmpty()) return "yes";
        else return "no";
    }
}