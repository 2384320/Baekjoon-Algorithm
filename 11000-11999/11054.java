import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static Integer[] dp1;
    static Integer[] dp2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp1 = new Integer[n];
        dp2 = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            asc(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            desc(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp1[i] + dp2[i] - 1, max);
        }

        bw.write(max + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static int asc(int num) {
        if (dp1[num] == null) {
            dp1[num] = 1;

            for (int i = num - 1; i >= 0; i--) {
                if (arr[i] < arr[num]) {
                    dp1[num] = Math.max(dp1[num], asc(i) + 1);
                }
            }
        }
        return dp1[num];
    }

    static int desc(int num) {
        if (dp2[num] == null) {
            dp2[num] = 1;

            for (int i = num + 1; i < dp2.length; i++) {
                if (arr[i] < arr[num]) {
                    dp2[num] = Math.max(dp2[num], desc(i) + 1);
                }
            }
        }
        return dp2[num];
    }
}