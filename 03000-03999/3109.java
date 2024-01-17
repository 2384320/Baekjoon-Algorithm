import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int r;
    private static int c;
    private static int[] dx = {-1, 0, 1};
    private static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int answer = 0;
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            if (map[i][0] != '.') continue;

            if (dfs(i, 0))
                answer++;
        }

        System.out.println(answer);
        br.close();
    }

    private static boolean dfs(int x, int y) {
        map[x][y] = '*';
        if (y == c - 1) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + 1;

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if (map[nx][ny] != '.') continue;

            if (dfs(nx, ny))
                return true;
        }
        return false;
    }
}