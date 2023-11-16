import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] % MOD + dp[i - 2] % MOD + dp[i - 3] % MOD) % MOD;
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
        br.close();
    }
}