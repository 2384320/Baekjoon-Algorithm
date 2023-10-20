import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    private static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            if (startX == endX && startY == endY)
                System.out.println(0);
            else
                System.out.println(bfs(startX, startY, endX, endY, l));
        }
        br.close();
    }

    private static int bfs(int startX, int startY, int endX, int endY, int l) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[l][l];

        queue.offer(new int[] {startX, startY});
        visited[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                if (visited[nx][ny] > 0) continue;
                visited[nx][ny] = visited[x][y] + 1;
                queue.offer(new int[] {nx, ny});
            }
        }

        return visited[endX][endY];
    }
}