import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowPeopleCount = Integer.parseInt(st.nextToken());

        boolean[] know = new boolean[n + 1];
        for (int i = 0; i < knowPeopleCount; i++) {
            know[Integer.parseInt(st.nextToken())] = true;
        }

        List<Integer>[] peoples = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            peoples[i] = new ArrayList<>();
        }

        int value, pre = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int peopleCount = Integer.parseInt(st.nextToken());

            if (peopleCount > 0) {
                pre = Integer.parseInt(st.nextToken());
                peoples[i].add(pre);
            }

            for (int j = 1; j < peopleCount; j++) {
                value = Integer.parseInt(st.nextToken());
                peoples[i].add(value);
                union(pre, value);
                pre = value;
            }
        }

        int parent;
        for (int i = 1; i < know.length; i++) {
            if (know[i])
                know[find(i)] = true;
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (peoples[i].size() > 0) {
                parent = find(peoples[i].get(0));
                if (!know[parent])
                    answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static void union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);

        parent[node2] = node1;
    }

    private static int find(int node) {
        if (parent[node] == node)
            return node;
        return find(parent[node]);
    }
}