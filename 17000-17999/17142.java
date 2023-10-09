import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, answer, originZeroCount;
    private static int[] moveX = {0, 0, 1, -1};
    private static int[] moveY = {1, -1, 0, 0};
    private static Virus[] virusSpot;
    private static int[][] arr;
    private static List<Virus> viruses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        originZeroCount = 0;

        virusSpot = new Virus[m];
        arr = new int[n][n];
        viruses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0)
                    originZeroCount++;
                else if (arr[i][j] == 2)
                    viruses.add(new Virus(i, j, 0));
            }
        }

        if (originZeroCount == 0)
            System.out.println(0);
        else {
            dfs(0, 0);
            System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        }
        br.close();
    }

    private static void dfs(int depth, int idx) {
        if (depth == m) {
            bfs(originZeroCount);
            return;
        }

        for (int i = idx; i < viruses.size(); i++) {
            virusSpot[depth] = viruses.get(i);
            dfs(depth + 1, i + 1);
        }
    }

    private static void bfs(int zeroCount) {
        Queue<Virus> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            Virus virus = virusSpot[i];
            visited[virus.x][virus.y] = true;
            queue.offer(virus);
        }

        while (!queue.isEmpty()) {
            Virus virus = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = virus.x + moveX[i];
                int ny = virus.y + moveY[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] || arr[nx][ny] == 1) continue;

                if (arr[nx][ny] == 0)
                    zeroCount--;

                if (zeroCount == 0) {
                    answer = Math.min(answer, virus.time + 1);
                    return;
                }

                visited[nx][ny] = true;
                queue.offer(new Virus(nx, ny, virus.time + 1));
            }
        }
    }
}

class Virus {
    int x, y, time;

    Virus(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}