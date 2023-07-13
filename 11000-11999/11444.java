import java.io.*;

public class Main {
    private static final long[][] origin = {{1, 1}, {1, 0}};
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        long[][] a = {{1, 1}, {1, 0}};

        bw.write(pow(a, n - 1)[0][0] + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static long[][] pow(long[][] a, long b) {
        if (b == 1L || b == 0) return a;

        long[][] result = pow(a, b / 2);
        result = multiply(result, result);

        if (b % 2 == 1L) result = multiply(result, origin);
        return result;
    }

    private static long[][] multiply(long[][] o1 , long[][] o2) {
        long[][] result = new long[2][2];
        result[0][0] = (o1[0][0] * o2[0][0] + o1[0][1] * o2[1][0]) % MOD;
        result[0][1] = (o1[0][0] * o2[0][1] + o1[0][1] * o2[1][1]) % MOD;
        result[1][0] = (o1[1][0] * o2[0][0] + o1[1][1] * o2[1][0]) % MOD;
        result[1][1] = (o1[1][0] * o2[0][1] + o1[1][1] * o2[1][1]) % MOD;
        return result;
    }
}