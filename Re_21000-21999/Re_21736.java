import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, answer;
    private static int[] moveX = {0, 0, 1, -1};
    private static int[] moveY = {1, -1, 0, 0};
    private static char[][] arr;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;

        arr = new char[n][m];
        visited = new boolean[n][m];

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }
        dfs(startX, startY);

        System.out.println(answer == 0 ? "TT" : answer);
        br.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        if (arr[x][y] == 'X')
            return;
        if (arr[x][y] == 'P')
            answer++;

        for (int i = 0; i < 4; i++) {
            int nx = x + moveX[i];
            int ny = y + moveY[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            if (visited[nx][ny])
                continue;

            dfs(nx, ny);
        }
    }
}