import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int to;
        int dist;

        Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    private static List<Node>[] usado;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        usado = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            usado[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            usado[p].add(new Node(q, r));
            usado[q].add(new Node(p, r));
        }

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];
            int answer = 0;

            queue.offer(v);
            visited[v] = true;

            while (!queue.isEmpty()) {
                int idx = queue.poll();

                for (Node n : usado[idx]) {
                    if (!visited[n.to] && n.dist >= k) {
                        answer++;
                        visited[n.to] = true;
                        queue.offer(n.to);
                    }
                }
            }
            System.out.println(answer);
        }
        br.close();
    }
}