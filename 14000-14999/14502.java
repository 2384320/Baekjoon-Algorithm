import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, num;
    private static int[] moveX = {0, 0, 1, -1};
    private static int[] moveY = {1, -1, 0, 0};
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = Integer.MIN_VALUE;
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        bw.write(num + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) continue;
                arr[i][j] = 1;
                dfs(depth + 1);
                arr[i][j] = 0;
            }
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) queue.offer(new int[] {i, j});
            }
        }

        int[][] clone = new int[n][m];
        for (int i = 0; i < n; i++) {
            clone[i] = arr[i].clone();
        }

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (clone[nx][ny] == 0) {
                    queue.offer(new int[] {nx, ny});
                    clone[nx][ny] = 2;
                }
            }
        }

        int sum = 0;
        for (int[] c : clone) {
            for (int N : c) {
                if (N == 0) sum++;
            }
        }
        num = Math.max(sum, num);
    }
}