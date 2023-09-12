import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] jewel = new int[n][2];
        int[] bag = new int[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(jewel, (e1, e2) -> {
            if (e1[0] == e2[0])
                return e2[1] - e1[1];
            return e1[0] - e2[0];
        });

        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        for (int i = 0, j = 0; i < k; i++) {
            while (j < n && jewel[j][0] <= bag[i])
                pq.offer(jewel[j++][1]);

            if (!pq.isEmpty())
                answer += pq.poll();
        }
        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}