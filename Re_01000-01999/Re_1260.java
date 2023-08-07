import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] visited;
    private static List<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }

        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int num : adjList[start]) {
            if (visited[num]) continue;
            dfs(num);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (visited[num]) continue;
            visited[num] = true;
            System.out.print(num + " ");

            for (int n : adjList[num]) {
                queue.offer(n);
            }
        }
    }
}