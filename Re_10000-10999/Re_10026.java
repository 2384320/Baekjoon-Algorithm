import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] colorWeakness;
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1, 0, 0};
    static char[][] picture;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        colorWeakness = new int[2];
        picture = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                picture[i][j] = arr[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                dfs(i, j);
                colorWeakness[0]++;
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'G') picture[i][j] = 'R';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                dfs(i, j);
                colorWeakness[1]++;
            }
        }

        System.out.println(colorWeakness[0] + " " + colorWeakness[1]);
        br.close();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        char ch = picture[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + moveX[i];
            int ny = y + moveY[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;

            if (visited[nx][ny] || picture[nx][ny] != ch)
                continue;

            dfs(nx, ny);
        }
    }
}