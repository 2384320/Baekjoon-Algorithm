import java.io.*;
import java.util.*;

public class Main {
    static Long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        dp = new Long[101];
        dp[1] = dp[2] = dp[3] = 1L;
        dp[4] = dp[5] = 2L;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(P(n) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static long P(int n) {
        if (dp[n] == null) dp[n] = P(n-1) + P(n-5);
        return dp[n];
    }
}