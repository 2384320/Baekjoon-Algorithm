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
    private static int n, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        List<Node>[] list = new ArrayList[n+1];
        List<Node>[] listR = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            listR[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, time));
            listR[to].add(new Node(from, time));
        }

        int[] dp = dijkstra(list);
        int[] dpR = dijkstra(listR);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i] + dpR[i]);
        }

        bw.write(max + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int[] dijkstra(List<Node>[] list) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(x, 0));

        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(arr, 100_000_000);
        arr[x] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int to = node.to;

            if (visited[to]) continue;
            visited[to] = true;

            for (Node nxt : list[to]) {
                if (arr[nxt.to] > arr[to] + nxt.time) {
                    arr[nxt.to] = arr[to] + nxt.time;
                    queue.offer(new Node(nxt.to, arr[nxt.to]));
                }
            }
        }
        return arr;
    }
}

class Node implements Comparable<Node> {
    int to, time;

    Node(int to, int time) {
        this.to = to;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.time, o.time);
    }
}