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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end));
        }

        int result = 0;
        int fill = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.end < fill) continue;

            if (fill < node.start)
                fill = node.start;

            int remain = (node.end - fill) % l;
            result += (node.end - fill) / l;
            fill = node.end;

            if (remain != 0) {
                result++;
                fill += l - remain;
            }
        }

        System.out.println(result);
        br.close();
    }
}