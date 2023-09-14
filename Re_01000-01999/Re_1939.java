import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int start, end;
    private static List<Bridge>[] bridge;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bridge = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            bridge[i] = new ArrayList<>();
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            max = Math.max(max, c);
            min = Math.min(min, c);
            bridge[a].add(new Bridge(b, c));
            bridge[b].add(new Bridge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int answer = 0;
        while (min <= max) {
            int mid = (max + min) / 2;
            visited = new boolean[n + 1];

            if (bfs(mid)) {
                min = mid + 1;
                answer = mid;
            }
            else
                max = mid - 1;
        }
        System.out.println(answer);
        br.close();
    }

    private static boolean bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == end)
                return true;

            for (Bridge b : bridge[node]) {
                if (b.weight >= num && !visited[b.to]) {
                    visited[b.to] = true;
                    queue.offer(b.to);
                }

            }
        }
        return false;
    }
}

class Bridge {
    int to, weight;

    Bridge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}