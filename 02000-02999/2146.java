import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] arr;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int number = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    setLand(i, j, n, number);
                    number++;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0)
                    answer = Math.min(answer, bfs(i, j, n));
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static void setLand(int x, int y, int n, int number) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][n];

        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        arr[x][y] = number;

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] || arr[nx][ny] != 1) continue;
                arr[nx][ny] = number;
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
    }

    private static int bfs(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][n];

        queue.offer(new int[] {x, y, 0});
        visited[x][y] = true;
        int number = arr[x][y];

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            int count = queue.peek()[2];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] || arr[nx][ny] == number) continue;
                if (arr[nx][ny] != 0)
                    return count;
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny, count + 1});
            }
        }
        return Integer.MAX_VALUE;
    }
}