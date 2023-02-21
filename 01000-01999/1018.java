import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        int black = 0, white = 0, result = n*m;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 8; i <= n; i++) {
            for (int j = 8; j <= m; j++) {
                black = coloring(i, j, 0);
                white = coloring(i, j, 1);
                if (black >= white && result > white) result = white;
                else if (black <= white && result > black) result = black;
            }
        }

        bw.write(result + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int coloring(int n, int m, int bnw) {
        int check = bnw;
        int count = 0;

        for (int i = n-8; i < n; i++) {
            for (int j = m-8; j < m; j++) {
                if (check == 1 && arr[i][j] == 'W') check = 0;
                else if (check == 0 && arr[i][j] == 'B') check = 1;
                else {
                    check = check == 1 ? 0 : 1;
                    count++;
                }
            }
            check = check == 1 ? 0 : 1;
        }
        return count;
    }
}