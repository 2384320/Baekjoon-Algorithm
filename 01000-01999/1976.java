import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        String answer = "YES";
        int root = parent[Integer.parseInt(st.nextToken())];
        for (int i = 1; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (parent[root] != parent[num]) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static int find(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = find(parent[node]);
    }

    private static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            if (root1 < root2)
                parent[root2] = root1;
            else
                parent[root1] = root2;
        }
    }
}