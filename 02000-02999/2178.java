import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] nx = {0, 0, 1, -1};
    public static int[] ny = {1, -1, 0, 0};
    public static int[][] map;
    public static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String str;
        map = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }

        bfs(1, 1);

        bw.write(visited[n-1][m-1] + "");

        bw.flush();
        br.close();
        bw.close();
    }
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = x + nx[i];
                int moveY = y + ny[i];

                if (moveX > 0 && moveX <= map.length && moveY > 0 && moveY <= map[0].length) {
                    if (map[moveX-1][moveY-1] == 1 && visited[moveX-1][moveY-1] == 0) {
                        queue.add(new int[]{moveX, moveY});
                        visited[moveX-1][moveY-1] = visited[x-1][y-1] + 1;
                    }
                }
            }
        }
    }
}