import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] dx = {0, 1};
    private static int[] dy = {1, 0};
    private static int[][] arr;
    private static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        dp = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1, 1));
        br.close();
    }

    private static long dfs(int x, int y) {
        if (x == n && y == n)
            return 1;

        if (dp[x][y] != -1)
            return dp[x][y];

        dp[x][y] = 0;
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * arr[x][y];
            int ny = y + dy[i] * arr[x][y];

            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            dp[x][y] += dfs(nx, ny);
        }
        return dp[x][y];
    }
}