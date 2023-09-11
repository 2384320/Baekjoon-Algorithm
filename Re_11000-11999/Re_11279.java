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

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.size() == 0) bw.write(0 + "\n");
                else bw.write(pq.poll() + "\n");
            } else
                pq.offer(x);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}