import java.io.*;

public class Main {
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer;

        arr = new int[n+1];
        dp = new Integer[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        
        bw.write(fibo(n) + "");
        bw.flush();
        br.close();
        bw.close();
    }
    public static int fibo(int n) {
        if (dp[n] == null) dp[n] = Math.max(fibo(n-2), fibo(n-3) + arr[n-1]) + arr[n];
        return dp[n];
    }
}