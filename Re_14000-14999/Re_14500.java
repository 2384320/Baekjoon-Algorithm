import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, result;
    private static int[] moveX = {0, 0, 1, -1};
    private static int[] moveY = {1, -1, 0, 0};
    private static int[][] arr;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = 0;
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(1, arr[i][j], i, j);
                visited[i][j] = false;
            }
        }
        System.out.println(result);
        br.close();
    }

    private static void dfs(int depth, int count, int x, int y) {
        if (depth == 4) {
            result = Math.max(result, count);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + moveX[i];
            int ny = y + moveY[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            if (visited[nx][ny])
                continue;

            if (depth == 2) {
                visited[nx][ny] = true;
                dfs(depth + 1, count + arr[nx][ny], x, y);
                visited[nx][ny] = false;
            }

            visited[nx][ny] = true;
            dfs(depth + 1, count + arr[nx][ny], nx, ny);
            visited[nx][ny] = false;
        }
    }
}