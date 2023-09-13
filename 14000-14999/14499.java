import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] moveX = {0, 0, -1, 1};
    private static int[] moveY = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] command = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        int[] dice = new int[6]; // 0: 위, 1: 북, 2: 동, 3: 남, 4: 서, 5: 아래
        dice[5] = map[x][y];
        for (int c : command) { // 1: 동, 2: 서, 3: 북, 4: 남
            int under = 0;
            int nx = x + moveX[c - 1];
            int ny = y + moveY[c - 1];

            if (nx >= n || ny >= m || nx < 0 || ny < 0)
                continue;

            if (c == 1) { // 아래 -> 서 -> 위 -> 동, 5 -> 4 -> 0 -> 2
                under = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
            } else if (c == 2) { // 아래 -> 동 -> 위 -> 서, 5 -> 2 -> 0 -> 4
                under = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
            } else if (c == 3) { // 아래 -> 남 -> 위 -> 북, 5 -> 3 -> 0 -> 1
                under = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
            } else if (c == 4) { // 아래 -> 북 -> 위 -> 남, 5 -> 1 -> 0 -> 3
                under = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
            }

            if (map[nx][ny] == 0) {
                dice[5] = under;
                map[nx][ny] = dice[5];
            } else {
                dice[5] = map[nx][ny];
                map[nx][ny] = 0;
            }

            x = nx;
            y = ny;
            bw.write(dice[0] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}