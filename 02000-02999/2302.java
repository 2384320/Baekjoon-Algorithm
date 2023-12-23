import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] vip = new int[m + 2];
        vip[0] = 0;
        vip[m + 1] = n + 1;
        for (int i = 1; i <= m; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(vip);

        List<Integer> diff = new ArrayList<>();
        int maxDiff = 0;
        for (int i = 0; i <= m; i++) {
            int d = vip[i + 1] - vip[i] - 1;
            diff.add(d);
            maxDiff = Math.max(maxDiff, d);
        }

        int[] dp = new int[maxDiff + 1];
        dp[0] = 1;
        int answer = 1;
        if (maxDiff != 0) {
            dp[1] = 1;

            for (int i = 2; i <= maxDiff; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            for (int dd : diff) {
                answer *= dp[dd];
            }
        }
        System.out.println(answer);
        br.close();
    }
}