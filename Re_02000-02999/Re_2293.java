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

        int[] money = new int[n];
        int[] dp = new int[k + 1];
        dp[0] = 1;
        
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
            for (int j = money[i]; j <= k; j++) {
                dp[j] += dp[j - money[i]];
            }
        }
        
        bw.write(dp[k] + "");
        bw.flush();
        br.close();
        bw.close();
    }
}