import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1, 0, 0};
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                visited[i][j] = Integer.parseInt(st.nextToken());
                if (visited[i][j] == 1) queue.add(new int[] {i, j});
            }
        }

        bfs();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = moveX[i] + x;
                int ny = moveY[i] + y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] != 0) continue;
                queue.add(new int[] {nx, ny});
                visited[nx][ny] = visited[x][y] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, visited[i][j]);
            }
        }
        System.out.println(max - 1);
    }
}