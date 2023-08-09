import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int answer;
    private static boolean[] visited;
    private static List<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        answer = -1;
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            adjList[num1].add(num2);
            adjList[num2].add(num1);
        }

        bfs(start, end);

        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});

        while (!queue.isEmpty()) {
            int p = queue.peek()[0];
            int count = queue.peek()[1];
            queue.poll();
            if (visited[p]) continue;
            visited[p] = true;

            for (int next : adjList[p]) {
                if (next == end) {
                    answer = count + 1;
                    return;
                }
                queue.offer(new int[] {next, count + 1});
            }
        }

    }
}