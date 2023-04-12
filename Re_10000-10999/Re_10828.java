import java.io.*;
import java.util.*;

import static java.lang.Float.NaN;

public class Main {
    static int[] stack;
    static int idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        stack = new int[n];
        String command;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            if (command.equals("push")) push(Integer.parseInt(st.nextToken()));
            else if (command.equals("size")) bw.write(size() + "\n");
            else if (command.equals("pop")) bw.write(pop() + "\n");
            else if (command.equals("empty")) bw.write(empty() + "\n");
            else if (command.equals("top")) bw.write(top() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void push(int num) { stack[idx++] = num; }

    public static int size() { return idx; }

    public static int pop() {
        if (size() == 0) return -1;
        else {
            int num = stack[idx - 1];
            stack[idx-- - 1] = 0;
            return num;
        }
    }

    public static int empty() {
        if (size() == 0) return 1;
        else return -0;
    }

    public static int top() {
        if (size() == 0) return -1;
        else return stack[idx - 1];
    }
}