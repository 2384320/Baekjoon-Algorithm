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

        for (int i = 0; i < n; i++) {
            asc(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }

        bw.write(max + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static int asc(int num) {
        if (dp[num] == null) {
            dp[num] = arr[num];

            for (int i = num - 1; i >= 0; i--) {
                if (arr[i] < arr[num]) {
                    dp[num] = Math.max(dp[num], asc(i) + arr[num]);
                }
            }
        }
        return dp[num];
    }
}