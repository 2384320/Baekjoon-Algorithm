import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;
    private static Node[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        adjList = new Node[e];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adjList[i] = new Node(from, to, dist);
        }

        Arrays.sort(adjList);

        for (int i = 1; i <= v; i++)
            parent[i] = i;

        int sum = 0;
        int count = 0;

        for (Node n : adjList) {
            if (union(n.from, n.to)) {
                sum += n.dist;
                count++;

                if (count == v - 1) break;
            }
        }

        bw.write(sum + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean union(int from, int to) {
        int f = findSet(from);
        int t = findSet(to);

        if (f == t) return false;
        parent[t] = f;
        return true;
    }

    private static int findSet(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findSet(parent[node]);
    }
}

class Node implements Comparable<Node> {
    int from, to, dist;

    public Node(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}

/* 프림 알고리즘
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] visited;
    private static List<Node>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        visited = new boolean[v + 1];
        adjList = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(to, dist));
            adjList[to].add(new Node(from, dist));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        int answer = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int to = n.to;
            int dist = n.dist;

            if (visited[to]) continue;
            visited[to] = true;
            answer += dist;

            for (Node nxt : adjList[to])
                pq.offer(nxt);
        }

        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }
}

class Node implements Comparable<Node> {
    int to, dist;

    public Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}
*/