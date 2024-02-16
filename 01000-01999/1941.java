import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int answer;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static char[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        arr = new char[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        dfs(0, 0);
        System.out.println(answer);
        br.close();
    }

    private static void dfs(int depth, int idx) {
        if (depth == 7) {
            if (bfs())
                answer++;
            return;
        }

        for (int i = idx; i < 25; i++) {
            visited[i / 5][i % 5] = true;
            dfs(depth + 1, i + 1);
            visited[i / 5][i % 5] = false;
        }
    }

    private static boolean bfs() {
        boolean[][] copyVisited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            copyVisited[i] = visited[i].clone();
        }

        int x = 0;
        int y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (copyVisited[i][j]) {
                    x = i;
                    y = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        int count = 0;
        int countS = 0;
        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (copyVisited[nx][ny]) {
                    if (arr[nx][ny] == 'S')
                        countS++;
                    count++;
                    queue.offer(new int[] {nx, ny});
                    copyVisited[nx][ny] = false;
                }
            }
        }

        return count == 7 && countS >= 4;
    }
}