import java.io.*;
import java.util.*;

public class Main {
    private static LinkedList<Integer>[] adjList;
    private static boolean[] visited;
    private static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        adjList = new LinkedList[n + 1];
        visited = new boolean[n + 1];
        answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }

        bfs(1);

        for (int i = 2; i <= n; i++) {
            bw.write(answer[i] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            node = queue.poll();

            for (int n : adjList[node]) {
                if (visited[n]) continue;
                answer[n] = node;
                visited[n] = true;
                queue.offer(n);
            }
        }
    }
}