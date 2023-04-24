import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        fibo(n);

        bw.write(dp[n] + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void fibo(int num) {
        dp = new int[num+1];
        dp[1] = 1;
        if (num == 1) return;
        dp[2] = 2;

        for (int i = 3; i <= num; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
    }
}