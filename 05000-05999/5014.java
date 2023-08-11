import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int f, u, d;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new boolean[f + 1];

        int count = bfs(s, g);
        if (count == -1) bw.write("use the stairs");
        else bw.write(count + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});

        while (!queue.isEmpty()) {
            int floor = queue.peek()[0];
            int count = queue.peek()[1];
            queue.poll();

            if (visited[floor]) continue;
            visited[floor] = true;

            if (floor == end) return count;

            int up = floor + u;
            int down = floor - d;

            if (up >= 1 && up <= f) {
                queue.offer(new int[] {up, count + 1});
            }

            if (down >= 1 && down <= f) {
                queue.offer(new int[] {down, count + 1});
            }
        }
        return -1;
    }
}