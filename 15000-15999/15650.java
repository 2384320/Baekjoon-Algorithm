import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];

        dfs(n, m, 0, 0);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dfs(int n, int m, int depth, int idx) {
        if (depth == m) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) System.out.print((i+1) + " ");
            }
            System.out.println();
        }

        for (int i = idx; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(n, m, depth+1, i+1);
            visited[i] = false;
        }
    }
}