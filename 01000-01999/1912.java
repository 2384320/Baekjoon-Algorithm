import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        dp = new Integer[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0] = arr[0];
        int max = arr[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        
        bw.write(max + "");
        bw.flush();
        br.close();
        bw.close();
    }
}