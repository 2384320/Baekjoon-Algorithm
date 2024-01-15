import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int start, end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Node(start, end));
        }

        int answer = 0;
        int idx = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.start >= idx)
                answer += Math.abs(node.end - node.start);
            else {
                if (idx < node.end)
                    answer += Math.abs(node.end - idx);
            }

            if (idx < node.end)
                idx = node.end;
        }
        System.out.println(answer);
        br.close();
    }
}