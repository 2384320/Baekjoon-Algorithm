import java.io.*;
import java.util.*;

public class Main {
    public static long[][] dp = new long[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int east, west;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            west = Integer.parseInt(st.nextToken());
            east = Integer.parseInt(st.nextToken());
            bw.write(BC(east, west) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static long BC(int N, int K) {
        // 이미 풀었던 sub 문제라면 값 재활용
        if (dp[N][K] > 0) {
            return dp[N][K];
        }
        // 조합 nCk = nC0 = 1 로 인한 조건문
        if (N == K || K == 0) {
            return dp[N][K] = 1;
        }
        // nCk = (n-1)C(k-1) + (n-1)Ck
        return dp[N][K] = (BC(N - 1, K - 1) + BC(N - 1, K));
    }
}