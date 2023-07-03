import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[][] products;
    private static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        products = new int[n][2];
        dp = new Integer[n][k+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            products[i][0] = Integer.parseInt(st.nextToken());
            products[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(backpack(n - 1, k) + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int backpack(int i, int k) {
        if (i < 0) return 0;

        if (dp[i][k] == null) {
            if (products[i][0] > k) dp[i][k] = backpack(i - 1, k);
            else dp[i][k] = Math.max(backpack(i - 1, k), backpack(i - 1, k - products[i][0]) + products[i][1]);
        }

        return dp[i][k];
    }
}

/* Bottom-Up 2차원 배열
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] products = new int[n + 1][2];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            products[i][0] = Integer.parseInt(st.nextToken());
            products[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (products[i][0] > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - products[i][0]] + products[i][1]);
            }
        }

        bw.write(dp[n][k] + "");
        br.close();
        bw.flush();
        bw.close();
    }
}
*/

/* Bottom-Up 1차원 배열
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] products = new int[n + 1][2];
        int[] dp = new int[k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            products[i][0] = Integer.parseInt(st.nextToken());
            products[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = k; j - products[i][0] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - products[i][0]] + products[i][1]);
            }
        }

        bw.write(dp[k] + "");
        br.close();
        bw.flush();
        bw.close();
    }
}
*/