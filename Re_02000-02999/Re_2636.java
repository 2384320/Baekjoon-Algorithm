import java.io.*;

public class Main {
    private static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        star(0, 0, n, false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(arr[i][j] + "");
            }
            bw.write("\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void star(int x, int y, int n, boolean isBlank) {
        if (isBlank) {
            for (int i = x; i < n + x; i++) {
                for (int j = y; j < n + y; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        int count = 0;
        for (int i = x; i < x + n; i+=n/3) {
            for (int j = y; j < y + n; j+=n/3) {
                count++;
                star(i, j, n/3, count == 5);
            }
        }
    }
}