import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Monkey {
        int x, y, k, count;

        Monkey(int x, int y, int k, int count) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.count = count;
        }
    }

    private static int w, h;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int[] hy = {-2, -1, 1, 2, -2, -1, 1, 2};
    private static int[][] arr;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        visited = new boolean[h][w][k + 1];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0, 0, k));
        br.close();
    }

    private static int bfs(int x, int y, int k) {
        Queue<Monkey> queue = new LinkedList<>();
        queue.offer(new Monkey(x, y, k, 0));
        visited[x][y][k] = true;

        while (!queue.isEmpty()) {
            Monkey monkey = queue.poll();
            if (monkey.x == h - 1 && monkey.y == w - 1) return monkey.count;

            if (monkey.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = monkey.x + hx[i];
                    int ny = monkey.y + hy[i];

                    if (isRange(nx, ny)) continue;
                    if (visited[nx][ny][monkey.k - 1] || arr[nx][ny] == 1) continue;
                    queue.offer(new Monkey(nx, ny, monkey.k - 1, monkey.count + 1));
                    visited[nx][ny][monkey.k - 1] = true;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = monkey.x + dx[i];
                int ny = monkey.y + dy[i];

                if (isRange(nx, ny)) continue;
                if (visited[nx][ny][monkey.k] || arr[nx][ny] == 1) continue;
                queue.offer(new Monkey(nx, ny, monkey.k, monkey.count + 1));
                visited[nx][ny][monkey.k] = true;
            }
        }
        return -1;
    }

    private static boolean isRange(int x, int y) {
        return x < 0 || x >= h || y < 0 || y >= w;
    }
}