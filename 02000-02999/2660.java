import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int minPoint = INF;
        int count = 0;
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        int[] point = new int[n + 1];
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j)
                    arr[i][j] = INF;
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if (num1 == -1) break;

            arr[num1][num2] = arr[num2][num1] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int score = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != INF)
                    score = Math.max(score, arr[i][j]);
            }

            point[i] = score;
            minPoint = Math.min(score, minPoint);
        }

        first.append(minPoint).append(" ");

        for (int i = 1; i <= n; i++) {
            if (minPoint == point[i]) {
                count++;
                second.append(i).append(" ");
            }
        }
        first.append(count);

        System.out.println(first);
        System.out.println(second);
        br.close();
    }
}