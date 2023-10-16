import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, answer, count;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] disk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        disk = new int[n][m];
        answer = 0;
        count = n * m;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                disk[i][j] = Integer.parseInt(st.nextToken());
                answer += disk[i][j];
            }
        }

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                if ((i + 1) % x != 0) continue;

                if (d == 0)
                    clockwise(i, k);
                else
                    counterclockwise(i, k);
            }

            boolean check = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (disk[i][j] == 0) continue;
                    if (findDuplication(i, j))
                        check = true;
                }
            }

            if (!check)
                setAllAvg();
        }

        System.out.println(answer);
        br.close();
    }

    private static boolean findDuplication(int x, int y) {
        boolean flag = false;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        visited[x][y] = true;
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n) continue;
                if (ny < 0)
                    ny = m - 1;
                else if (ny >= m)
                    ny = 0;

                if (visited[nx][ny] || disk[nx][ny] == 0) continue;

                if (disk[x][y] == disk[nx][ny]) {
                    visited[nx][ny] = true;
                    flag = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

        if (!flag) return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    answer -= disk[i][j];
                    count--;
                    disk[i][j] = 0;
                }
            }
        }
        return true;
    }

    private static void clockwise(int line, int count) {
        while (count-- > 0) {
            int tmp = disk[line][0];
            for (int i = 1; i < m; i++) {
                int nxt = disk[line][i];
                disk[line][i] = tmp;
                tmp = nxt;
            }
            disk[line][0] = tmp;
        }
    }

    private static void counterclockwise(int line, int count) {
        while (count-- > 0) {
            int tmp = disk[line][m - 1];
            for (int i = m - 2; i >= 0; i--) {
                int nxt = disk[line][i];
                disk[line][i] = tmp;
                tmp = nxt;
            }
            disk[line][m - 1] = tmp;
        }
    }

    private static void setAllAvg() {
        double avg = (double) answer / count;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (disk[i][j] == 0) continue;

                if ((double) disk[i][j] > avg) {
                    disk[i][j]--;
                    answer--;
                } else if ((double) disk[i][j] < avg) {
                    disk[i][j]++;
                    answer++;
                }
            }
        }
    }
}