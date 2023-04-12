import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] rgb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        rgb = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];

        bw.write(Math.min(fibo(n - 1, 0), Math.min(fibo(n - 1, 1), fibo(n - 1, 2))) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int fibo(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == 0) dp[n][0] = Math.min(fibo(n - 1, 1), fibo(n - 1, 2)) + rgb[n][0];
            else if (color == 1) dp[n][1] = Math.min(fibo(n - 1, 0), fibo(n - 1, 2)) + rgb[n][1];
            else dp[n][2] = Math.min(fibo(n - 1, 0), fibo(n - 1, 1)) + rgb[n][2];
        }
        return dp[n][color];
    }
}