import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, homeX, homeY, festivalX, festivalY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            List<int[]> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new int[]{x, y});
            }

            st = new StringTokenizer(br.readLine());
            festivalX = Integer.parseInt(st.nextToken());
            festivalY = Integer.parseInt(st.nextToken());

            if (bfs(list))
                System.out.println("happy");
            else
                System.out.println("sad");
        }

        br.close();
    }

    private static boolean bfs(List<int[]> list) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(new int[]{homeX, homeY});

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            if (Math.abs(x - festivalX) + Math.abs(y - festivalY) <= 1000)
                return true;

            for (int i = 0; i < n; i++) {
                if (visited[i])
                    continue;

                int nx = list.get(i)[0];
                int ny = list.get(i)[1];

                if (Math.abs(x - nx) + Math.abs(y - ny) <= 1000) {
                    visited[i] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        return false;
    }
}