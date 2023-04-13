import java.io.*;
import java.util.*;

public class Main {
    static int answer, n, m;
    static int[][] visited;
    static int[][] map;
    static int[][] countArr;
    static int[] nx = {0, 0, 1, -1};
    static int[] ny = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = -1;
        visited = new int[n][m];
        map = new int[n][m];
        countArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] mapStr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(mapStr[j]);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(0, 0);

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 1, 0});
        visited[x][y] = 0;

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            int dis = queue.peek()[2];
            int count = queue.peek()[3];
            queue.poll();

            if (x == n-1 && y == m-1) {
                answer = dis;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int moveX = nx[i] + x;
                int moveY = ny[i] + y;

                if (moveX < 0 || moveX >= map.length || moveY < 0 || moveY >= map[0].length) continue;
                if (visited[moveX][moveY] <= count) continue;

                if (map[moveX][moveY] == 1) {
                    if (count != 0) continue;
                    queue.add(new int[] {moveX, moveY, dis + 1, count + 1});
                    visited[moveX][moveY] = count + 1;
                } else {
                    queue.add(new int[] {moveX, moveY, dis + 1, count});
                    visited[moveX][moveY] = count;
                }
            }
        }

    }
}