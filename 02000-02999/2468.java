import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, answer, max;
    private static int[] moveX = {0, 0, 1, -1};
    private static int[] moveY = {1, -1, 0, 0};
    private static int[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        answer = 0;
        for (int i = 0; i <= max; i++) {
            int tmp = 0;
            visited = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] <= i || visited[j][k]) continue;
                    tmp += bfs(i, j, k);
                }
            }
            answer = Math.max(tmp, answer);
        }

        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int bfs(int depth, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] || arr[nx][ny] <= depth) continue;
                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
        return 1;
    }
}