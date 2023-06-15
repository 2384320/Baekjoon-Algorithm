import java.io.*;
import java.util.*;

public class Main {
    private static int max, startNode;
    private static List<Tree>[] list;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int v = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        startNode = 0;
        list = new ArrayList[v+1];
        visited = new boolean[v+1];

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while (true) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) break;
                int dist = Integer.parseInt(st.nextToken());

                list[num].add(new Tree(node, dist));
                list[node].add(new Tree(num, dist));
            }
        }

        dfs(1, 0);
        visited = new boolean[v+1];
        dfs(startNode, 0);

        bw.write(max + "");
        br.close();
        bw.flush();
        bw.close();
    }
    private static void dfs(int num, int length) {
        if (length > max) {
            max = length;
            startNode = num;
        }

        visited[num] = true;

        for (int i = 0; i < list[num].size(); i++) {
            Tree t = list[num].get(i);
            if (visited[t.node]) continue;

            dfs(t.node, t.dist + length);
            visited[t.node] = true;
        }
    }
}

class Tree {
    int node, dist;

    public Tree(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}