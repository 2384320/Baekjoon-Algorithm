import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static boolean[] visited;
    private static List<Integer>[] adjLink;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        visited = new boolean[n + 1];

        adjLink = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjLink[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            adjLink[num1].add(num2);
            adjLink[num2].add(num1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjLink[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int num) {
        if (visited[num])
            return;

        visited[num] = true;
        for (int i = 1; i <= n; i++) {
            if (adjLink[num].contains(i))
                dfs(i);
        }
    }
}