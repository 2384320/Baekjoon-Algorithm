import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        boolean[][] dp = new boolean[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] == arr[i + 1])
                dp[i][i + 1] = true;
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (dp[s][e]) bw.write("1\n");
            else bw.write("0\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}