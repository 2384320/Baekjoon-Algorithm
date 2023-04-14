import java.io.*;
import java.util.*;

public class Main {
    static int idx = 0;
    static int[] deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        deque = new int[n];
        String command;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            if (command.equals("push_front")) push_front(Integer.parseInt(st.nextToken()));
            else if (command.equals("push_back")) push_back(Integer.parseInt(st.nextToken()));
            else if (command.equals("pop_front")) bw.write(pop_front() + "\n");
            else if (command.equals("pop_back")) bw.write(pop_back() + "\n");
            else if (command.equals("size")) bw.write(size() + "\n");
            else if (command.equals("empty")) bw.write(empty() + "\n");
            else if (command.equals("front")) bw.write(front() + "\n");
            else if (command.equals("back")) bw.write(back() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void push_front(int num) {
        for (int i = idx; i > 0; i--) {
            deque[i] = deque[i-1];
        }
        deque[0] = num;
        idx++;
    }

    public static void push_back(int num) {
        deque[idx++] = num;
    }

    public static int pop_front() {
        if (empty() == 1) return -1;
        int num = deque[0];
        for (int i = 0; i < idx - 1; i++) {
            deque[i] = deque[i+1];
        }
        deque[idx-1] = 0;
        idx--;
        return num;
    }

    public static int pop_back() {
        if (empty() == 1) return -1;
        int num = deque[idx-1];
        deque[idx-1] = 0;
        idx--;
        return num;
    }

    public static int size() {
        return idx;
    }

    public static int empty() {
        if (size() == 0) return 1;
        return 0;
    }

    public static int front() {
        if (empty() == 1) return -1;
        return deque[0];
    }

    public static int back() {
        if (empty() == 1) return -1;
        return deque[idx-1];
    }
}