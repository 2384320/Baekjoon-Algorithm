import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 200_000_000;

    private static int n, e;
    private static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int d1 = 0;
        d1 += dijkstra(1, v1);
        d1 += dijkstra(v1, v2);
        d1 += dijkstra(v2, n);
        
        int d2 = 0;
        d2 += dijkstra(1, v2);
        d2 += dijkstra(v2, v1);
        d2 += dijkstra(v1, n);

        int answer = (d1 >= INF && d2 >= INF) ? -1 : Math.min(d1, d2);
        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int dijkstra(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>();
        int[] dp = new int[n+1];
        boolean[] visited = new boolean[n + 1];

        queue.offer(new Node(start, 0));
        Arrays.fill(dp, INF);
        dp[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int to = node.to;

            if (visited[to]) continue;
            visited[to] = true;

            for (Node nxt : list[to]) {
                if (dp[nxt.to] > dp[to] + nxt.dist) {
                    dp[nxt.to] = dp[to] + nxt.dist;
                    queue.offer(new Node(nxt.to, dp[nxt.to]));
                }
            }
        }
        return dp[end];
    }
}

class Node implements Comparable<Node> {
    int to;
    int dist;

    Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.dist, o.dist);
    }
}