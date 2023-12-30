import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.StringTokenizer;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int t = 1;  
  
        while (true) {  
            int n = Integer.parseInt(br.readLine());  
            if (n == 0) break;  
            int[][] arr = new int[n][3];  
            int[][] dp = new int[n][3];  
  
            for (int i = 0; i < n; i++) {  
                StringTokenizer st = new StringTokenizer(br.readLine());  
                for (int j = 0; j < 3; j++) {  
                    arr[i][j] = Integer.parseInt(st.nextToken());  
                }  
            }  
  
            dp[0][0] = Integer.MAX_VALUE;  
            dp[0][1] = arr[0][1];  
            dp[0][2] = arr[0][1] + arr[0][2];  
  
            for (int i = 1; i < n; i++) {  
                for (int j = 0; j < 3; j++) {  
                    if (j == 0)  
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);  
                    else if (j == 1) {  
                        dp[i][j] = arr[i][j] + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), Math.min(dp[i - 1][j], dp[i - 1][j + 1]));  
                    } else {  
                        if (i == n - 1) break;  
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));  
                    }  
                }  
            }  
            System.out.println(t + ". " + dp[n - 1][1]);  
            t++;  
        }  
        br.close();  
    }  
}