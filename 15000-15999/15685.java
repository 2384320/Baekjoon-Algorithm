import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] moveX = {1, 0, -1, 0};
    private static int[] moveY = {0, -1, 0, 1};
    private static boolean[][] isDragonCurve;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        isDragonCurve = new boolean[101][101];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dragonCurve(x, y, d, g);
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (isDragonCurve[i][j]
                        && isDragonCurve[i + 1][j]
                        && isDragonCurve[i][j + 1]
                        && isDragonCurve[i + 1][j + 1])
                    answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static void dragonCurve(int x, int y, int d, int g) {
        List<Integer> list = new ArrayList<>();
        list.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);
            }
        }

        isDragonCurve[x][y] = true;
        for (int direction : list) {
            x += moveX[direction];
            y += moveY[direction];
            isDragonCurve[x][y] = true;
        }
    }
}