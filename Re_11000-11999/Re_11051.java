import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];

        bw.write(BC(n, k) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int BC(int n, int k) {
        if (dp[n][k] > 0) return dp[n][k];
        if (n == k || k == 0) return 1;
        dp[n][k] = (BC(n - 1, k - 1) + BC(n - 1, k)) % 10007;
        return dp[n][k];
    }
}