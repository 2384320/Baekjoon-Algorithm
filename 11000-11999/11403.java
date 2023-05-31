import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb;
    static boolean[] visited;
    static LinkedList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        adjList = new LinkedList[n+1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    adjList[i+1].add(j+1);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited = new boolean[n+1];

        while (!queue.isEmpty()) {
            node = queue.poll();

            Iterator<Integer> it = adjList[node].iterator();
            while (it.hasNext()) {
                int num = it.next();
                if (visited[num]) continue;
                visited[num] = true;
                queue.offer(num);
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
    }
}