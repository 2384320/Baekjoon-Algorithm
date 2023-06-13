import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c;
        while ((c = Integer.parseInt(br.readLine())) != -1) {
            Queue<Integer> queue = new LinkedList<>();
            int sum = 0;
            for (int i = 1; i < c; i++) {
                if (c % i != 0) continue;
                queue.offer(i);
                sum += i;
            }

            if (sum != c) bw.write(c + " is NOT perfect.");
            else {
                bw.write(c + " =");
                bw.write(" " + queue.poll());
                while (!queue.isEmpty()) {
                    bw.write(" + " + queue.poll());
                }
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}