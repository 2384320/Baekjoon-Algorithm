import java.io.*;
import java.util.*;

import static java.lang.Float.NaN;

public class Main {
    public static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();
        String command;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            switch (command) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (empty() == 1) bw.write(-1 + "\n");
                    else bw.write(pop() + "\n");
                    break;
                case "size":
                    bw.write(size() + "\n");
                    break;
                case "empty":
                    bw.write(empty() + "\n");
                    break;
                case "front":
                    if (empty() == 1) bw.write(-1 + "\n");
                    else bw.write(front() + "\n");
                    break;
                case "back":
                    if (empty() == 1) bw.write(-1 + "\n");
                    else bw.write(back() + "\n");
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
    public static void push(int num) { queue.add(num); }
    public static int pop() {
        return queue.remove();
    }
    public static int size() { return queue.size(); }
    public static int empty() {
        if (queue.size() == 0) return 1;
        else return 0;
    }
    public static int front() { return queue.peek(); }
    public static int back() {
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
        int result = queue.peek();
        queue.add(queue.remove());
        return result;

    }
}