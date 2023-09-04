import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static Integer[] dp1, dp2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp1 = new Integer[n];
        dp2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            asc(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            desc(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }

        bw.write(max + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int asc(int num) {
        if (dp1[num] == null) {
            dp1[num] = 1;

            for (int i = num - 1; i >= 0; i--) {
                if (arr[i] < arr[num])
                    dp1[num] = Math.max(dp1[num], asc(i) + 1);
            }
        }
        return dp1[num];
    }

    private static int desc(int num) {
        if (dp2[num] == null) {
            dp2[num] = 1;

            for (int i = num + 1; i < dp2.length; i++) {
                if (arr[i] < arr[num])
                    dp2[num] = Math.max(dp2[num], desc(i) + 1);
            }
        }
        return dp2[num];
    }
}