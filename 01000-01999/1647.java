import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] visited;
    private static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        bw.write(prim() + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int prim() {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 0));
        int max = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (visited[node.to]) continue;
            visited[node.to] = true;
            max = Math.max(max, node.dist);
            answer += node.dist;

            for (Node nxt : list[node.to]) {
                if (visited[nxt.to]) continue;
                queue.offer(nxt);
            }
        }
        return answer - max;
    }
}

class Node implements Comparable<Node> {
    int to, dist;

    Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}