import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, blackCount, whiteCount;

    private static int[] dx = {-1, 1, 1, -1};
    private static int[] dy = {1, 1, -1, -1};
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        blackCount = 0;
        whiteCount = 0;
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] blackVisited = new boolean[n][n];
        blackSearch(blackVisited, 0, 0, 0);

        boolean[][] whiteVisited = new boolean[n][n];
        whiteSearch(whiteVisited, 0, 1, 0);

        System.out.println(blackCount + whiteCount);
        br.close();
    }

    private static void blackSearch(boolean[][] visited, int x, int y, int count) {
        blackCount = Math.max(count, blackCount);

        if (y >= n) {
            x++;
            y = x % 2 == 0 ? 0 : 1;
        }
        if (x >= n) return;

        if (isAble(visited, x, y)) {
            visited[x][y] = true;
            blackSearch(visited, x, y + 2, count + 1);
            visited[x][y] = false;
        }

        blackSearch(visited, x, y + 2, count);
    }

    private static void whiteSearch(boolean[][] visited, int x, int y, int count) {
        whiteCount = Math.max(count, whiteCount);

        if (y >= n) {
            x++;
            y = x % 2 == 0 ? 1 : 0;
        }
        if (x >= n) return;

        if (isAble(visited, x, y)) {
            visited[x][y] = true;
            whiteSearch(visited, x, y + 2, count + 1);
            visited[x][y] = false;
        }

        whiteSearch(visited, x, y + 2, count);
    }

    private static boolean isAble(boolean[][] visited, int x, int y) {
        if (arr[x][y] == 0) return false;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            for (int j = 0; j < n; j++) {
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) return false;

                nx += dx[i];
                ny += dy[i];
            }
        }
        return true;
    }
}