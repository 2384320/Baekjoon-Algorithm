import java.io.*;
import java.util.*;

public class Main {
    static int m, n, countArea, countZero;
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            for (int i = startX; i < endX; i++) {
                for (int j = startY; j < endY; j++) {
                    map[i][j] = 1;
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 || visited[i][j]) continue;
                countArea++;
                bfs(i, j);
                list.add(countZero);
            }
        }
        Collections.sort(list);
        bw.write(countArea + "\n");
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int x, int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        countZero = 1;

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (map[nx][ny] != 0 || visited[nx][ny]) continue;
                queue.add(new int[] {nx, ny});
                visited[nx][ny] = true;
                countZero++;
            }
        }
    }
}