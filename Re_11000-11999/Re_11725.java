import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] answer;
    private static boolean[] visited;
    private static List<Integer>[] abjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        answer = new int[n + 1];
        abjList = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            abjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            abjList[a].add(b);
            abjList[b].add(a);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
        br.close();
    }

    private static void dfs(int num) {
        visited[num] = true;

        for (int nxt : abjList[num]) {
            if (visited[nxt]) continue;
            answer[nxt] = num;
            dfs(nxt);
        }
    }
}