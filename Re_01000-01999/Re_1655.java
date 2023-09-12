import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (minPQ.size() == maxPQ.size()) {
                maxPQ.offer(num);

                while (!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
                    minPQ.offer(maxPQ.poll());
                    maxPQ.offer(minPQ.poll());
                }
            } else {
                minPQ.offer(num);

                if (maxPQ.peek() > minPQ.peek()) {
                    minPQ.offer(maxPQ.poll());
                    maxPQ.offer(minPQ.poll());
                }
            }
            bw.write(maxPQ.peek() + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}