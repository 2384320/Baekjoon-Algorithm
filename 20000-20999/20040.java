import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;
    private static List<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            parent[i] = i;
        }

        int time = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            int parent_node1 = find(node1);
            int parent_node2 = find(node2);
            union(node1, node2);

            if (parent_node1 == parent_node2) {
                time = i;
                break;
            }
        }

        bw.write(time + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int find(int node) {
        if (parent[node] == node) return parent[node];
        return parent[node] = find(parent[node]);
    }

    private static void union(int node1, int node2) {
        int parent_node1 = find(node1);
        int parent_node2 = find(node2);
        parent[parent_node2] = parent_node1;
    }
}