import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int[] dp;
    private static String[] arr;
    private static final int MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().split("");
        n = arr.length;
        dp = new int[n + 1];

        System.out.println(secret());
        br.close();
    }

    private static int secret() {
        if (arr[0].equals("0"))
            return 0;

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int num = Integer.parseInt(arr[i - 2] + arr[i - 1]);

            if (num <= 26 && num >= 1) {
                if (arr[i - 1].equals("0"))
                    dp[i] = dp[i - 2];
                else if (arr[i - 2].equals("0"))
                    dp[i] = dp[i - 1];
                else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                    dp[i] %= MOD;
                }
            } else {
                if (arr[i - 1].equals("0"))
                    return 0;
                else
                    dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}