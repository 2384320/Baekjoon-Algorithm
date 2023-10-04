import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, l, r;
    private static int[] moveX = {0, 0, 1, -1};
    private static int[] moveY = {1, -1, 0, 0};
    private static int[][] arr;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean flag = false;
        while (!flag){
            flag = true;
            visited = new boolean[n][n];
            answer++;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j])
                        continue;
                    if (!bfs(i, j))
                        flag = false;
                }
            }
        }

        System.out.println(answer - 1);
        br.close();
    }

    private static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        int sum = arr[x][y];
        int count = 1;

        queue.offer(new int[] {x, y});
        list.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if (visited[nx][ny])
                    continue;

                int diff = Math.abs(arr[nx][ny] - arr[x][y]);
                if (diff >= l && diff <= r) {
                    visited[nx][ny] = true;
                    sum += arr[nx][ny];
                    count++;
                    list.add(new int[] {nx, ny});
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        int avg = sum / count;

        if (count == 1)
            return true;

        for (int[] spot : list) {
            arr[spot[0]][spot[1]] = avg;
        }
        return false;
    }
}