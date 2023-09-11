import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            pq.offer(num);
        }

        long answer = 0;
        while (pq.size() > 1) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            
            answer += num1 + num2;
            pq.offer(num1 + num2);
        }
        
        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }
}