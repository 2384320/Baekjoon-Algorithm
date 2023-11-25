import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {0, 0, 0, 0, 1, -1};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dz = {1, -1, 0, 0, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (l == 0) break;

            int startX = 0, startY = 0, startZ = 0;
            int endX = 0, endY = 0, endZ = 0;

            char[][][] arr = new char[r][c][l];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < c; k++) {
                        arr[j][k][i] = str.charAt(k);
                        if (arr[j][k][i] == 'S') {
                            startX = j;
                            startY = k;
                            startZ = i;
                        }
                        if (arr[j][k][i] == 'E') {
                            endX = j;
                            endY = k;
                            endZ = i;
                        }
                    }
                }
                br.readLine();
            }

            int answer = bfs(arr, r, c, l, startX, startY, startZ, endX, endY, endZ);
            if (answer == -1)
                System.out.println("Trapped!");
            else
                System.out.println("Escaped in " + answer + " minute(s).");
        }
        br.close();
    }

    private static int bfs(char[][][] arr, int r, int c, int l, int startX, int startY, int startZ, int endX, int endY, int endZ) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[r][c][l];

        queue.offer(new int[] {startX, startY, startZ, 1});
        visited[startX][startY][startZ] = true;

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int z = queue.peek()[2];
            int count = queue.peek()[3];
            queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || nz < 0 || nz >= l) continue;
                if (visited[nx][ny][nz] || arr[nx][ny][nz] == '#') continue;
                if (arr[nx][ny][nz] == 'E')
                    return count;
                visited[nx][ny][nz] = true;
                queue.offer(new int[] {nx, ny, nz, count + 1});
            }
        }
        return -1;
    }
}