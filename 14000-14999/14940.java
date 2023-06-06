import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) num = -1;
                if (num == 2) {
                    startX = i;
                    startY = j;
                }
                arr[i][j] = num;
            }
        }

        bfs(startX, startY, arr, n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs(int x, int y, int[][] arr, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        arr[x][y] = 0;

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = moveX[i] + x;
                int ny = moveY[i] + y;

                if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;
                if (arr[nx][ny] >= 0) continue;

                queue.offer(new int[] {nx, ny});
                arr[nx][ny] = arr[x][y] + 1;
            }
        }
    }
}