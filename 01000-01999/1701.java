import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int v;
    private static int[] visited;
    private static List<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList = new ArrayList[v + 1];
            visited = new int[v + 1];

            for (int i = 1; i <= v; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adjList[a].add(b);
                adjList[b].add(a);
            }
            bfs();
        }
        br.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                visited[i] = 1;
            }

            while (!queue.isEmpty()) {
                int num = queue.poll();

                for (int j = 0; j < adjList[num].size(); j++) {
                    if (visited[adjList[num].get(j)] == 0)
                        queue.offer(adjList[num].get(j));

                    if (visited[adjList[num].get(j)] == visited[num]) {
                        System.out.println("NO");
                        return;
                    }

                    if (visited[num] == 1 && visited[adjList[num].get(j)] == 0)
                        visited[adjList[num].get(j)] = 2;
                    else if (visited[num] == 2 && visited[adjList[num].get(j)] == 0)
                        visited[adjList[num].get(j)] = 1;
                }
            }
        }
        System.out.println("YES");
    }
}