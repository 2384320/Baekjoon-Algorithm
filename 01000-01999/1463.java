import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dp = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        fibonacci(n);
        bw.write(dp[n] + "");
        bw.flush();
        br.close();
        bw.close();
    }
    public static void fibonacci(int n) {
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0 && dp[i] > dp[i/2] + 1) dp[i] = dp[i/2] + 1;
            if (i % 3 == 0 && dp[i] > dp[i/3] + 1) dp[i] = dp[i/3] + 1;
        }
    }
}