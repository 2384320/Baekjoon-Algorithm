import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {num1, num2});
        }

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> fuels = new PriorityQueue<>(Comparator.reverseOrder());

        int answer = 0;
        while (p < l) {
            while (!pq.isEmpty() && pq.peek()[0] <= p)
                fuels.offer(pq.poll()[1]);

            if (fuels.isEmpty()) {
                answer = -1;
                break;
            }

            answer++;
            p += fuels.poll();
        }

        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }
}