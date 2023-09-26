import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp = new Long[101];
        dp[1] = dp[2] = dp[3] = 1L;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(P(n));
        }

        br.close();
    }

    private static long P(int num) {
        if (dp[num] == null)
            dp[num] = P(num - 2) + P(num - 3);
        return dp[num];
    }
}