import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int to, dist;

        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    private static final int INF = 100_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);

            List<Node>[] adjList = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < m + w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                if (i < m) {
                    adjList[s].add(new Node(e, t));
                    adjList[e].add(new Node(s, t));
                } else
                    adjList[s].add(new Node(e, -t));
            }

            boolean bellmanFord = false;
            dist[1] = 0;

            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    for (Node nxt : adjList[j]) {
                        if (dist[nxt.to] > dist[j] + nxt.dist)
                            dist[nxt.to] = dist[j] + nxt.dist;
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                for (Node nxt : adjList[i]) {
                    if (dist[nxt.to] > dist[i] + nxt.dist) {
                        bellmanFord = true;
                        break;
                    }
                }
                if (bellmanFord) break;
            }

            if (bellmanFord)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        br.close();
    }
}