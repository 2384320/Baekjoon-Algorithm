import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x, y, r;

        Node(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            parent = new int[n];
            Node[] nodes = new Node[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(x, y, r);
            }

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    Node node1 = nodes[i];
                    Node node2 = nodes[j];

                    if (find(i) == find(j)) continue;

                    int r = (int) Math.pow(node1.r + node2.r, 2);
                    int dis = (int) (Math.pow(node1.x - node2.x, 2) + Math.pow(node1.y - node2.y, 2));

                    if (r >= dis)
                        union(i, j);
                }
            }

            Set<Integer> set = new HashSet<>();
            for (int num : parent) {
                set.add(find(num));
            }
            System.out.println(set.size());
        }
        br.close();
    }

    private static int find(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = find(parent[node]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[y] = x;
    }
}