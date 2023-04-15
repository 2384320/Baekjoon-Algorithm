import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            queue.add(i+1);
        }

        while (queue.size() != 1) {
            queue.poll();
            queue.add(queue.peek());
            queue.poll();
        }

        bw.write(queue.peek() + "");

        bw.flush();
        br.close();
        bw.close();
    }
}