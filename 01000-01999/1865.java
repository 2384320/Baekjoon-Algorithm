import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 100_000_000;

    private static int n;
    private static int[] dist;
    private static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list = new ArrayList[n+1];
            dist = new int[n+1];
            Arrays.fill(dist, INF);
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < m + w; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());

                if (i < m) {
                    list[from].add(new Node(to, dist));
                    list[to].add(new Node(from, dist));
                } else list[from].add(new Node(to, -dist));
            }
            bw.write(bellmanFord() ? "YES\n" : "NO\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean bellmanFord() {
        dist[1] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < list.length; j++) {
                for (Node nxt : list[j]) {
                    if (dist[nxt.to] > dist[j] + nxt.dist)
                        dist[nxt.to] = dist[j] + nxt.dist;
                }
            }
        }

        for (int i = 1; i < list.length; i++) {
            for (Node nxt : list[i]) {
                if (dist[nxt.to] > dist[i] + nxt.dist) return true;
            }
        }
        return false;
    }
}

class Node {
    int to;
    int dist;

    Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}