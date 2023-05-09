import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[] arr = new boolean[n+1];
            int sum = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) return o1[0] - o2[0];
                    return o1[1] - o2[1];
                }
            });

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            for (int i = 0; i < m; i++) {
                int start = pq.peek()[0];
                int end = pq.peek()[1];
                for (int j = start; j <= end; j++) {
                    if (!arr[j]) {
                        arr[j] = true;
                        break;
                    }
                }
                pq.poll();
            }

            for (int i = 1; i <= n; i++) {
                if (arr[i]) sum++;
            }
            bw.write(sum+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}