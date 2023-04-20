import java.io.*;
import java.util.*;

public class Main {
    static int cheese, n, m, time, count;
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cheese = 0;
        time = 0;
        count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) cheese++;
                map[i][j] = num;
            }
        }

        while (cheese != 0) {
            time++;
            count = cheese;
            bfs();
        }
        bw.write(time + "\n" + count);

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][m];
        visited[0][0] = true;
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

                if (map[nx][ny] == 1) {
                    cheese--;
                    map[nx][ny] = 0;
                } else if (map[nx][ny] == 0) {
                    queue.add(new int[] {nx, ny});
                }
                visited[nx][ny] = true;
            }
        }
    }
}