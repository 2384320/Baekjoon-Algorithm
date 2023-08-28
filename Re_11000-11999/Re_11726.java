import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static final int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        if (n >= 2) {
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % MOD;
            }
        }
        bw.write(dp[n] + "");
        bw.flush();
        br.close();
        bw.close();
    }
}