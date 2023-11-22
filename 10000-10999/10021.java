import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int start, end;
        long dist;

        Node(int start, int end, long dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> (int) (o1.dist - o2.dist));

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                long d = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
                queue.offer(new Node(i, j, d));
            }
        }

        int sum = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.dist < c) continue;

            int nx = node.start;
            int ny = node.end;

            if (!isSame(nx, ny)) {
                sum += node.dist;
                union(nx, ny);
                count++;
            }

            if (count == n - 1) break;
        }

        if (count != n - 1)
            sum = -1;

        System.out.println(sum);
        br.close();
    }

    public static boolean isSame(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);

        return node1 == node2;
    }

    public static int find(int node) {
        if (node == parent[node])
            return node;
        return find(parent[node]);
    }

    public static void union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);

        if (node1 != node2)
            parent[node1] = node2;
    }
}