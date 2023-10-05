import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int max, startNode;
    private static boolean[] visited;
    private static List<Tree>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[parent].add(new Tree(child, v));
            list[child].add(new Tree(parent, v));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(startNode, 0);

        System.out.println(max);
        br.close();
    }

    private static void dfs(int num, int length) {
        if (length > max) {
            max = length;
            startNode = num;
        }

        visited[num] = true;

        for (int i = 0; i < list[num].size(); i++) {
            Tree tree = list[num].get(i);
            if (visited[tree.node])
                continue;
            dfs(tree.node, length + tree.dist);
            visited[tree.node] = true;
        }
    }
}

class Tree {
    int node, dist;

    Tree(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}