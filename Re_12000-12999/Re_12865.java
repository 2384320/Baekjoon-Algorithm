import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] products;
    private static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        products = new int[n][2];
        dp = new Integer[n][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            products[i][0] = Integer.parseInt(st.nextToken());
            products[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(backpack(n - 1, k));
        br.close();
    }

    private static int backpack(int i, int k) {
        if (i < 0) return 0;

        if (dp[i][k] == null) {
            if (products[i][0] > k)
                dp[i][k] = backpack(i - 1, k);
            else
                dp[i][k] = Math.max(backpack(i - 1, k), backpack(i - 1, k - products[i][0]) + products[i][1]);
        }
        return dp[i][k];
    }
}