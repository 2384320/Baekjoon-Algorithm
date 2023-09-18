import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] moveX = {-1, 0, 1, 0};
    private static int[] moveY = {0, 1, 0, -1};
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int startDirection = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(startX, startY, startDirection));
        br.close();
    }

    private static int bfs(int x, int y, int d) {
        int count = 0;

        while (true) {
            boolean check = false;

            if (map[x][y] == 0) {
                map[x][y] = 2;
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = moveX[d] + x;
                int ny = moveY[d] + y;

                d = (d + 3) % 4;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (map[nx][ny] == 0)
                    check = true;
            }

            if (check) {
                d = (d + 3) % 4;

                int nx = moveX[d] + x;
                int ny = moveY[d] + y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (map[nx][ny] == 0) {
                    x += moveX[d];
                    y += moveY[d];
                }
            } else {
                int back = (d + 2) % 4;
                int nx = x + moveX[back];
                int ny = y + moveY[back];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (map[nx][ny] == 1)
                    break;
                else {
                    x = nx;
                    y = ny;
                }
            }
        }

        return count;
    }
}