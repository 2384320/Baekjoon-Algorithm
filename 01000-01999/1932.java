import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static Integer[][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n-1][i] = arr[n-1][i];
        }

        bw.write(fibo(0, 0) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int fibo(int depth, int idx) {
        if (depth == n - 1) return dp[depth][idx];

        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max(fibo(depth + 1, idx), fibo(depth + 1, idx + 1)) + arr[depth][idx];
        }
        return dp[depth][idx];
    }
}