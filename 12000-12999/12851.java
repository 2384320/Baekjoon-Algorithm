import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, k, minTime, count;
    private static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        minTime = Integer.MAX_VALUE;
        count = 0;
        time = new int[100001];

        if (n >= k) bw.write((n - k) + "\n1");
        else {
            bfs(n);
            bw.write(minTime + "\n" + count);
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        time[n] = 1;

        while (!queue.isEmpty()) {
            n = queue.poll();

            if (minTime < time[n]) return;

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) nx = n + 1;
                else if (i == 1) nx = n - 1;
                else nx = n * 2;

                if (nx < 0 || nx > 100000) continue;

                if (nx == k) {
                    minTime = time[n];
                    count++;
                }

                if (time[nx] == 0 || time[nx] == time[n] + 1) {
                    queue.offer(nx);
                    time[nx] = time[n] + 1;
                }
            }
        }

    }
}