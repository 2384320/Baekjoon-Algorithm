import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] chess;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        chess = new int[n];

        dfs(0);
        bw.write(answer+"");

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int depth) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            chess[depth] = i;
            if (possibility(depth)) dfs(depth + 1);
        }
    }
    public static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
            // 같은 행에 존재할 경우
            if (chess[col] == chess[i]) return false;
            // 대각선상에 놓여있는 경우
            else if (Math.abs(col - i) == Math.abs(chess[col] - chess[i])) return false;
        }
        return true;
    }
}