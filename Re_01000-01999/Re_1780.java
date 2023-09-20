import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int minusOne, zero, one;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        minusOne = 0; zero = 0; one = 0;
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0, n);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
        br.close();
    }

    private static void recursion(int x, int y, int size) {
        if (size == 1) {
            getNumber(map[x][y]);
            return;
        }

        if (check(x, y, size)) {
            getNumber(map[x][y]);
            return;
        }

        int recursionSize = size / 3;

        recursion(x, y, recursionSize);
        recursion(x + recursionSize, y, recursionSize);
        recursion(x + recursionSize * 2, y, recursionSize);

        recursion(x, y + recursionSize, recursionSize);
        recursion(x + recursionSize, y + recursionSize, recursionSize);
        recursion(x + recursionSize * 2, y + recursionSize, recursionSize);

        recursion(x, y + recursionSize * 2, recursionSize);
        recursion(x + recursionSize, y + recursionSize * 2, recursionSize);
        recursion(x + recursionSize * 2, y + recursionSize * 2, recursionSize);
    }

    private static boolean check(int x, int y, int size) {
        int num = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (num != map[i][j])
                    return false;
            }
        }
        return true;
    }

    private static void getNumber(int num) {
        switch (num) {
            case -1: minusOne++; break;
            case 0: zero++; break;
            case 1: one++; break;
        }
    }
}