import java.io.*;
import java.util.*;

public class Main {
    static int idx = 0;
    static int[] queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        queue = new int[n];
        String command;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            if (command.equals("push")) push(Integer.parseInt(st.nextToken()));
            else if (command.equals("pop")) bw.write(pop() + "\n");
            else if (command.equals("size")) bw.write(size() + "\n");
            else if (command.equals("empty")) bw.write(empty() + "\n");
            else if (command.equals("front")) bw.write(front() + "\n");
            else if (command.equals("back")) bw.write(back() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void push(int num) {
        queue[idx++] = num;
    }

    public static int pop() {
        if (empty() == 1) return -1;
        int num = queue[0];
        for (int i = 0; i < idx; i++) {
            queue[i] = queue[i+1];
        }
        idx--;
        return num;
    }

    public static int size() {
        return idx;
    }

    public static int empty() {
        if (size() == 0) return 1;
        else return 0;
    }

    public static int front() {
        if (empty() == 1) return -1;
        return queue[0];
    }

    public static int back() {
        if (empty() == 1) return -1;
        return queue[idx-1];
    }
}