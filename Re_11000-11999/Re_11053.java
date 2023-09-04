import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new Integer[n];
        for (int i = 0; i < n; i++) {
            fibo(i);
        }

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        bw.write(max + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int fibo(int num) {
        if (dp[num] == null) {
            dp[num] = 1;

            for (int i = num - 1; i >= 0; i--) {
                if (arr[i] < arr[num])
                    dp[num] = Math.max(dp[num], fibo(i) + 1);
            }
        }
        return dp[num];
    }
}