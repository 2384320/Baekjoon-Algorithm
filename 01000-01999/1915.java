import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.StringTokenizer;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());  
        int n = Integer.parseInt(st.nextToken());  
        int m = Integer.parseInt(st.nextToken());  
        int[][] arr = new int[n][m];  
        int[][] dp = new int[n + 1][m + 1];  
        int answer = 0;  
  
        for (int i = 0; i < n; i++) {  
            String str = br.readLine();  
            for (int j = 0; j < m; j++) {  
                arr[i][j] = str.charAt(j) - '0';  
            }  
        }  
  
        if (n < 2 || m < 2) {  
            for (int i = 0; i < n; i++) {  
                if (arr[i][0] == 1) {  
                    answer = 1;  
                    break;
                }  
            }  
  
            for (int i = 0; i < m; i++) {  
                if (arr[0][i] == 1) {  
                    answer = 1;  
                    break;
                }  
            }  
  
        } else {  
            for (int i = 1; i <= n; i++) {  
                for (int j = 1; j <= m; j++) {  
                    if (i == 1 && j == 1)  
                        dp[i][j] = arr[i - 1][j - 1];  
                    else {  
                        if (arr[i - 1][j - 1] == 1) {  
                            dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;  
                            answer = Math.max(dp[i][j], answer);  
                        }  
                    }  
                }  
            }  
        }  
        System.out.println(answer * answer);  
        br.close();  
    }  
}