import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int n, totalPeople, min;
    private static int[][] population;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        totalPeople = 0;
        min = Integer.MAX_VALUE;

        population = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                population[i][j] =  Integer.parseInt(st.nextToken());
                totalPeople += population[i][j];
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int d1 = 1; d1 < n; d1++) {
                    for (int d2 = 1; d2 < n; d2++) {
                        if (x + d1 + d2 >= n) continue;
                        if (y - d1 < 0 || y + d2 >= n) continue;

                        zone(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.println(min);
        br.close();
    }

    private static void zone(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[n][n];

        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        int[] people = new int[5];

        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) break;
                people[0] += population[i][j];
            }
        }

        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if (border[i][j]) break;
                people[1] += population[i][j];
            }
        }

        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                people[2] += population[i][j];
            }
        }

        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                people[3] += population[i][j];
            }
        }

        people[4] = totalPeople;

        for (int i = 0; i < 4; i++) {
            people[4] -= people[i];
        }

        Arrays.sort(people);
        min = Math.min(min, people[4] - people[0]);
    }
}