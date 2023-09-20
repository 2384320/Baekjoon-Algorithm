import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb;
    private static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        quadTree(0, 0, n);
        System.out.println(sb.toString());
        br.close();
    }

    private static void quadTree(int x, int y, int size) {
        if (size == 1) {
            sb.append(map[x][y]);
            return;
        }

        if (check(x, y, size)) {
            sb.append(map[x][y]);
            return;
        }

        int recursionSize = size / 2;
        sb.append("(");
        quadTree(x, y, recursionSize);
        quadTree(x, y + recursionSize, recursionSize);
        quadTree(x + recursionSize, y, recursionSize);
        quadTree(x + recursionSize, y + recursionSize, recursionSize);
        sb.append(")");
    }

    private static boolean check(int x, int y, int size) {
        char ch = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (ch != map[i][j])
                    return false;
            }
        }
        return true;
    }
}