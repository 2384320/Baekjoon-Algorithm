import java.io.*;
import java.util.*;

import static java.lang.Float.NaN;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        String command;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            if (command.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
            else if (command.equals("size")) bw.write(stack.size() + "\n");
            else if (command.equals("pop")) {
                if (stack.empty()) bw.write(-1 + "\n");
                else {
                    bw.write(stack.peek() + "\n");
                    stack.pop();
                }
            }
            else if (command.equals("empty")) bw.write((stack.empty() ? 1 : 0) + "\n");
            else if (command.equals("top")) {
                if (stack.empty()) bw.write(-1 + "\n");
                else bw.write(stack.peek() + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}