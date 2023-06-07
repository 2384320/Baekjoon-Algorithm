import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= Math.sqrt(i); j++) {
                int tmp = i - (j*j);
                min = Math.min(min, dp[tmp]);
            }
            dp[i] = min + 1;
        }

        bw.write(dp[n] + "");
        bw.flush();
        br.close();
        bw.close();
    }
}