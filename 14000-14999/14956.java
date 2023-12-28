import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] spot = miro(n, m, 1, 1, 0);
        System.out.println(spot[0] + " " + spot[1]);
        br.close();
    }

    private static int[] miro(int n, int m, int x, int y, int d) {
        if (n == 1)
            return new int[] {y, x};

        n /= 2;
        int size = n * n;

        if (d == 0) {
            if (1 <= m && m <= size)
                return miro(n, m, x, y, 1);
            else if (size < m && m <= 2 * size)
                return miro(n, m - size, x + n, y, 0);
            else if (2 * size < m && m <= 3 * size)
                return miro(n, m - 2 * size, x + n, y + n, 0);
            return miro(n, m - 3 * size, x + n - 1, y + 2 * n - 1, 3);
        } else if (d == 1) {
            if (1 <= m && m <= size)
                return miro(n, m, x, y, 0);
            else if (size < m && m <= 2 * size)
                return miro(n, m - size, x, y + n, 1);
            else if (2 * size < m && m <= 3 * size)
                return miro(n, m - 2 * size, x + n, y + n, 1);
            return miro(n, m - 3 * size, x + 2 * n - 1, y + n - 1, 2);
        } else if (d == 2) {
            if (1 <= m && m <= size)
                return miro(n, m, x, y, 3);
            else if (size < m && m <= 2 * size)
                return miro(n, m - size, x - n, y, 2);
            else if (2 * size < m && m <= 3 * size)
                return miro(n, m - 2 * size, x - n, y - n, 2);
            return miro(n, m - 3 * size, x - n + 1, y - 2 * n + 1, 1);
        }
        if (1 <= m && m <= size)
            return miro(n, m, x, y, 2);
        else if (size < m && m <= 2 * size)
            return miro(n, m - size, x, y - n, 3);
        else if (2 * size < m && m <= 3 * size)
            return miro(n, m - 2 * size, x - n, y - n, 3);
        return miro(n, m - 3 * size, x - 2 * n + 1, y - n + 1, 0);
    }
}