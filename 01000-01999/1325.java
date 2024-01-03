import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] count;
    private static boolean[] visited;
    private static List<Integer>[] list;
    private static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        count = new int[n + 1];
        list = new List[n + 1];
        queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];

            visited[i] = true;
            count[i]++;
            queue.offer(i);

            bfs();
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, count[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (count[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int nxt : list[node]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    count[nxt]++;
                    queue.add(nxt);
                }
            }
        }
    }
}