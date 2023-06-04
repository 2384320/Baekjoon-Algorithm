import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static int[] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        chess = new int[n];

        dfs(0);

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int depth) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            chess[depth] = i;
            if (checkQueen(depth)) dfs(depth + 1);
        }
    }

    private static boolean checkQueen(int line) {
        for (int i = 0; i < line; i++) {
            if (chess[i] == chess[line]) return false;
            if (Math.abs(line - i) == Math.abs(chess[line] - chess[i])) return false;
        }
        return true;
    }
}