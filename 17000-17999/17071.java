import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, k;
    private static int[][] visited = new int[2][500001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(visited[0], -1);
        Arrays.fill(visited[1], -1);
        visited[0][n] = 0;

        System.out.println(n == k ? 0 : bfs());
        br.close();
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        int size, mod, time = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            time++;
            mod = time % 2;

            for (int i = 0; i < size; i++) {
                int x = queue.poll();

                if (isRange(mod, x - 1)) {
                    queue.offer(x - 1);
                    visited[mod][x - 1] = time;
                }
                if (isRange(mod, x + 1)) {
                    queue.offer(x + 1);
                    visited[mod][x + 1] = time;
                }
                if (isRange(mod, x * 2)) {
                    queue.offer(x * 2);
                    visited[mod][x * 2] = time;
                }
            }

            int end = k + (time * (time + 1) / 2);
            if (end > 500000) break;
            if (visited[mod][end] != -1)
                return time;
        }
        return -1;
    }

    private static boolean isRange(int mod, int x) {
        return x <= 500000 && x >= 0 && visited[mod][x] == -1;
    }
}