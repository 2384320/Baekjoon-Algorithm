import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final int START_X = 0;
    private static final int START_Y = 1;

    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private static final int DIAGONAL = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][][] dp = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[START_X][START_Y][HORIZONTAL] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (arr[i][j] == 1) continue;
                dp[i][j][HORIZONTAL] = dp[i][j-1][HORIZONTAL] + dp[i][j-1][DIAGONAL];

                if (i == 0) continue;
                dp[i][j][VERTICAL] = dp[i-1][j][VERTICAL] + dp[i-1][j][DIAGONAL];

                if (arr[i-1][j] == 1 || arr[i][j-1] == 1) continue;
                dp[i][j][DIAGONAL] = dp[i-1][j-1][HORIZONTAL]
                        + dp[i-1][j-1][VERTICAL]
                        + dp[i-1][j-1][DIAGONAL];
            }
        }

        bw.write((dp[n-1][n-1][HORIZONTAL] + dp[n-1][n-1][VERTICAL] + dp[n-1][n-1][DIAGONAL]) + "");
        br.close();
        bw.flush();
        bw.close();
    }
}