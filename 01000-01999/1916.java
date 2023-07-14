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
    private static List<Node>[] list;
    private static int[] dp;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        dp = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        bw.write(dp[end] + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        dp[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int to = node.to;

            if (visited[to]) continue;
            visited[to] = true;

            for (Node nxt : list[to]) {
                if (dp[nxt.to] >= dp[to] + nxt.dist) {
                    dp[nxt.to] = dp[to] + nxt.dist;
                    queue.offer(new Node(nxt.to, dp[nxt.to]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
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