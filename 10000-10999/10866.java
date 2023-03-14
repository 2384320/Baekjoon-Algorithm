import java.io.*;
import java.util.*;

import static java.lang.Float.NaN;

public class Main {
    public static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        deque = new LinkedList<>();
        String command;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            switch (command) {
                case "push_back":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (empty() == 1) bw.write(-1 + "\n");
                    else bw.write(deque.remove() + "\n");
                    break;
                case "pop_back":
                    if (empty() == 1) bw.write(-1 + "\n");
                    else bw.write(deque.removeLast() + "\n");
                    break;
                case "size":
                    bw.write(size() + "\n");
                    break;
                case "empty":
                    bw.write(empty() + "\n");
                    break;
                case "front":
                    if (empty() == 1) bw.write(-1 + "\n");
                    else bw.write(deque.getFirst() + "\n");
                    break;
                case "back":
                    if (empty() == 1) bw.write(-1 + "\n");
                    else bw.write(deque.getLast() + "\n");
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static int size() { return deque.size(); }
    public static int empty() {
        if (deque.size() == 0) return 1;
        else return 0;
    }
}