import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int n;
    static int s;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (s == 0) bw.write(answer - 1 + "");
        else bw.write(answer + "");

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int depth, int sum) {
        if (depth == n) {
            if (s == sum) answer++;
            return;
        }

        dfs(depth + 1, sum + num[depth]);
        dfs(depth + 1, sum);
    }
}