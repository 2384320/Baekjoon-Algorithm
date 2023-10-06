import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] moveX = {1, -1, 0, 0};
    private static int[] moveY = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] room = new int[r][c];
        int upX, downX = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1)
                    downX = i;
            }
        }
        upX = downX - 1;

        while (t-- > 0) {
            diffusion(r, c, room);
            circulateUp(upX, c, room);
            circulateDown(downX, r, c, room);
        }

        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] > 0)
                    answer += room[i][j];
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static void diffusion(int r, int c, int[][] room) {
        int[][] after = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] == -1)
                    after[i][j] = -1;

                if (room[i][j] <= 0)
                    continue;

                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + moveX[k];
                    int ny = j + moveY[k];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c)
                        continue;
                    if (room[nx][ny] == -1)
                        continue;
                    count++;
                }

                after[i][j] += room[i][j] - (room[i][j] / 5) * count;

                for (int k = 0; k < 4; k++) {
                    int nx = i + moveX[k];
                    int ny = j + moveY[k];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c)
                        continue;
                    if (room[nx][ny] == -1)
                        continue;
                    after[nx][ny] += room[i][j] / 5;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (after[i][j] > 0)
                    room[i][j] = after[i][j];
            }
        }
    }

    private static void circulateUp(int upX, int c, int[][] room) {
        int tmp;
        int nxt = 0;
        for (int i = 1; i < c; i++) {
            tmp = room[upX][i];
            room[upX][i] = nxt;
            nxt = tmp;
        }

        for (int i = upX - 1; i >= 0; i--) {
            tmp = room[i][c - 1];
            room[i][c - 1] = nxt;
            nxt = tmp;
        }

        for (int i = c - 2; i >= 0; i--) {
            tmp = room[0][i];
            room[0][i] = nxt;
            nxt = tmp;
        }

        for (int i = 1; i < upX; i++) {
            tmp = room[i][0];
            room[i][0] = nxt;
            nxt = tmp;
        }
    }

    private static void circulateDown(int downX, int r, int c, int[][] room) {
        int tmp;
        int nxt = 0;
        for (int i = 1; i < c; i++) {
            tmp = room[downX][i];
            room[downX][i] = nxt;
            nxt = tmp;
        }

        for (int i = downX + 1; i < r; i++) {
            tmp = room[i][c - 1];
            room[i][c - 1] = nxt;
            nxt = tmp;
        }

        for (int i = c - 2; i >= 0; i--) {
            tmp = room[r - 1][i];
            room[r - 1][i] = nxt;
            nxt = tmp;
        }

        for (int i = r - 2; i > downX; i--) {
            tmp = room[i][0];
            room[i][0] = nxt;
            nxt = tmp;
        }
    }
}