import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] s;
    static boolean[] printArr;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            s = new int[k];
            printArr = new boolean[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int depth, int idx) throws IOException {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (printArr[i]) bw.write(s[i] + " ");
            }
            bw.write("\n");
        }

        for (int i = idx; i < k; i++) {
            printArr[i] = true;
            dfs(depth + 1, i + 1);
            printArr[i] = false;
        }

    }
}