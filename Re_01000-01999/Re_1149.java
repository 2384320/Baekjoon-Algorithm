import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        bw.write(Math.min(fibo(n - 1, 0), Math.min(fibo(n - 1, 1), fibo(n - 1, 2))) + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int fibo(int x, int color) {
        if (dp[x][color] == 0) {
            if (color == 0)
                dp[x][0] = Math.min(fibo(x - 1, 1), fibo(x - 1, 2)) + arr[x][0];
            else if (color == 1)
                dp[x][1] = Math.min(fibo(x - 1, 0), fibo(x - 1, 2)) + arr[x][1];
            else
                dp[x][2] = Math.min(fibo(x - 1, 0), fibo(x - 1, 1)) + arr[x][2];
        }
        return dp[x][color];
    }
}