import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD = 1_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(a, b, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int[][] pow(int[][] a, long b, int n) {
        if (b == 1L) return a;

        int[][] result = pow(a, b / 2, n);
        result = multiply(result, result, n);

        if (b % 2 == 1L) result = multiply(result, a, n);
        return result;
    }

    private static int[][] multiply(int[][] o1 , int[][] o2, int n) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += o1[i][k] * o2[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}