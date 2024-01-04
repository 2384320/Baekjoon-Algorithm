import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            List<Integer>[] adjList = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                adjList[i] = new ArrayList<>();
            }

            int[] requiredTime = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                requiredTime[i] = Integer.parseInt(st.nextToken());
            }

            int[] inDegree = new int[n + 1];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                adjList[v1].add(v2);
                inDegree[v2]++;
            }

            int end = Integer.parseInt(br.readLine());
            System.out.println(bfs(n, end, requiredTime, inDegree, adjList));
        }

        br.close();
    }

    private static int bfs(int n, int end, int[] requiredTime, int[] inDegree, List<Integer>[] adjList) {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = requiredTime[i];

            if (inDegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i : adjList[node]) {
                result[i] = Math.max(result[i], result[node] + requiredTime[i]);
                inDegree[i]--;

                if (inDegree[i] == 0)
                    queue.offer(i);
            }
        }

        return result[end];
    }
}