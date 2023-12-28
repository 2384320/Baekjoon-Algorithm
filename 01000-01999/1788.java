import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            if (n > 0)
                System.out.println(1);
            else {
                n = -n;
                if (n % 2 == 0)
                    System.out.println(-1);
                else
                    System.out.println(1);
            }

            n = Math.abs(n);
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
                dp[i] %= MOD;
            }
            System.out.println(dp[n]);
        }
        br.close();
    }
}