import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];
        int answer = INF;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][3];
        for (int i = 0; i < 3; i++) {
            dp[1][i] = arr[1][i];
            dp[1][(i + 1) % 3] = dp[1][(i + 2) % 3] = INF;
            
            for (int j = 2; j <= n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
            }
            
            answer = Math.min(answer, Math.min(dp[n][(i + 1) % 3], dp[n][(i + 2) % 3]));
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}