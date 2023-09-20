import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, l;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (calRow(i))
                count++;
            if (calCol(i))
                count++;
        }
        System.out.println(count);
        br.close();
    }

    private static boolean calRow(int row) {
        boolean[] incline = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = map[row][i] - map[row][i + 1];

            if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || incline[i + j])
                        return false;
                    if (map[row][i] - 1 != map[row][i + j])
                        return false;
                    incline[i + j] = true;
                }
            } else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || incline[i - j])
                        return false;
                    if (map[row][i] != map[row][i - j])
                        return false;
                    incline[i - j] = true;
                }
            } else if (diff > 1 || diff < -1)
                return false;
        }
        return true;
    }

    private static boolean calCol(int col) {
        boolean[] incline = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = map[i][col] - map[i + 1][col];

            if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || incline[i + j])
                        return false;
                    if (map[i][col] - 1 != map[i + j][col])
                        return false;
                    incline[i + j] = true;
                }
            } else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || incline[i - j])
                        return false;
                    if (map[i][col] != map[i - j][col])
                        return false;
                    incline[i - j] = true;
                }
            } else if (diff > 1 || diff < -1)
                return false;
        }
        return true;
    }
}