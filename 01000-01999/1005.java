import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] requiredTime, inDegree;
    private static List<Integer>[] adjList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            adjList = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++)
                adjList[i] = new ArrayList<>();

            requiredTime = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++)
                requiredTime[i] = Integer.parseInt(st.nextToken());

            inDegree = new int[n + 1];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                adjList[v1].add(v2);
                inDegree[v2]++;
            }

            int end = Integer.parseInt(br.readLine());
            bw.write(bfs(end) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int bfs(int end) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = requiredTime[i];

            if (inDegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i : adjList[node]) {
                result[i] = Math.max(result[i], result[node] + requiredTime[i]);
                inDegree[i]--;

                if (inDegree[i] == 0)
                    q.offer(i);
            }
        }

        return result[end];
    }
}