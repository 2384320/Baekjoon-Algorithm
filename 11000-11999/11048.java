import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] arr;
    private static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new Integer[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(candy(n - 1, m - 1));
        br.close();
    }

    private static Integer candy(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m)
            return 0;
        if (dp[x][y] == null) {
            dp[x][y] = Math.max(candy(x - 1, y), Math.max(candy(x, y - 1), candy(x - 1, y - 1))) + arr[x][y];
        }
        return dp[x][y];
    }
}