import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        search();
        br.close();
    }

    private static void search() {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];
        int maxDist = 0;

        Arrays.fill(distance, -1);
        distance[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int nn : adjList[num]) {
                if (distance[nn] != -1) continue;
                queue.offer(nn);
                distance[nn] = distance[num] + 1;
                if (maxDist < distance[nn])
                    maxDist = distance[nn];
            }
        }

        boolean flag = true;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDist) {
                if (flag) {
                    flag = false;
                    System.out.print(i + " " + maxDist + " ");
                }
                count++;
            }
        }
        System.out.println(count);
    }
}