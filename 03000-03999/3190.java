import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int[] moveX = {0, 1, 0, -1};
    private static int[] moveY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        Map<Integer, String> turn = new HashMap<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int round = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            turn.put(round, direction);
        }

        int headX = 0;
        int headY = 0;
        int time = 0;
        int currentDirection = 0;
        List<int[]> snake = new ArrayList<>();
        snake.add(new int[] {0, 0});

        while (true) {
            time++;

            int nx = headX + moveX[currentDirection];
            int ny = headY + moveY[currentDirection];

            if (isFinish(nx, ny, n, snake))
                break;

            if (board[nx][ny] == 1) {
                board[nx][ny] = 0;
                snake.add(new int[] {nx, ny});
            } else {
                snake.add(new int[] {nx, ny});
                snake.remove(0);
            }

            if (turn.containsKey(time)) {
                if (turn.get(time).equals("D"))
                    currentDirection = (currentDirection + 1) % 4;
                else {
                    currentDirection--;
                    if (currentDirection == -1)
                        currentDirection = 3;
                }
            }

            headX = nx;
            headY = ny;
        }

        bw.write(time + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isFinish(int nx, int ny, int n, List<int[]> snake) {
        if (nx >= n || ny >= n || nx < 0 || ny < 0)
            return true;
        for (int[] spot : snake) {
            if (spot[0] == nx && spot[1] == ny)
                return true;
        }
        return false;
    }
}