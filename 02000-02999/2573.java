import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] moveX = {0, 0, 1, -1};
    private static int[] moveY = {1, -1, 0, 0};
    private static int[][] map;
    private static boolean[][] visited, check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (isNotTwo()) {
            if (isAllMelt()) {
                answer = 0;
                break;
            }

            answer++;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0 || visited[i][j])
                        continue;
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static boolean isNotTwo() {
        check = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !check[i][j]) {
                    check(i, j);
                    count++;
                }
            }
        }
        return count < 2;
    }

    private static boolean isAllMelt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    private static void check(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        check[x][y] = true;

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (check[nx][ny] || map[nx][ny] == 0)
                    continue;

                queue.offer(new int[] {nx, ny});
                check[nx][ny] = true;
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (visited[nx][ny])
                    continue;

                if (map[nx][ny] != 0) {
                    map[nx][ny]--;
                    if (map[nx][ny] == 0)
                        visited[nx][ny] = true;
                } else {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}