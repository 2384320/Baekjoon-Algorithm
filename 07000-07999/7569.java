import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h, answer;
    static int[] moveX = {0, 0, 1, -1, 0, 0};
    static int[] moveY = {1, -1, 0, 0, 0, 0};
    static int[] moveZ = {0, 0, 0, 0, 1, -1};
    static int[][][] map;
    static Queue<int[]> isTomato = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[n][m][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    if (tomato == 1) isTomato.add(new int[] {j, k, i});
                    map[j][k][i] = tomato;
                }
            }
        }
        answer = bfs();

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
    public static int bfs() {
        int count = 0;

        while (!isTomato.isEmpty()) {
            int x = isTomato.peek()[0];
            int y = isTomato.peek()[1];
            int z = isTomato.peek()[2];
            isTomato.poll();

            for (int i = 0; i < 6; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];
                int nz = z + moveZ[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) continue;
                if (map[nx][ny][nz] == 0) {
                    map[nx][ny][nz] = map[x][y][z] + 1;
                    isTomato.add(new int[] {nx, ny, nz});
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[j][k][i] == 0) return -1;
                    count = Math.max(count, map[j][k][i]);
                }
            }
        }
        return count - 1;
    }
}