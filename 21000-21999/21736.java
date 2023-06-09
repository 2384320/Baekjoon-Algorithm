import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1, 0, 0};
    static char[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        arr = new char[n][m];
        visited = new boolean[n][m];

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++) {
            char[] chArr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = chArr[j];
                if (arr[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }
        bfs(startX, startY);

        if (answer == 0) bw.write("TT");
        else bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];

                if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;
                if (visited[nx][ny] || arr[nx][ny] == 'X') continue;

                queue.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
                if (arr[nx][ny] == 'P') answer++;
            }
        }
    }
}