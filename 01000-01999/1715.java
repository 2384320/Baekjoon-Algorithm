import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(br.readLine()));
        }

        long answer = 0;
        while (queue.size() > 1) {
            long num1 = queue.poll();
            long num2 = queue.poll();

            answer += num1 + num2;
            queue.add(num1 + num2);
        }

        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }
}