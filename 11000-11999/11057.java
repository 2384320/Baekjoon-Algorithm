import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
  
public class Main {  
    private static final int MOD = 10007;  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int n = Integer.parseInt(br.readLine());  
        int[][] dp = new int[10][n + 1];  
  
        for (int i = 0; i < 10; i++) {  
            dp[i][1] = 1;  
        }  
  
        for (int i = 2; i <= n; i++) {  
            dp[0][i] = 1;  
        }  
  
        for (int i = 1; i < 10; i++) {  
            for (int j = 2; j <= n; j++) {  
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;  
            }  
        }  
  
        int answer = 0;  
        for (int i = 0; i < 10; i++) {  
            answer += dp[i][n];  
            answer %= MOD;  
        }  
  
        System.out.println(answer);  
        br.close();  
    }  
}