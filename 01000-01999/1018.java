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

        // 체스판은 최소 크기가 8x8이므로 한 칸씩 옆으로 이동하도록 함.
        for (int i = 8; i <= n; i++) {
            for (int j = 8; j <= m; j++) {
                // coloring의 count: 각 색이 첫번째라고 할 때, 칠해야하는 칸의 수
                black = coloring(i, j, 0);
                white = coloring(i, j, 1);
                // 구했던 값들과 전에 구했던 result를 비교하여 최솟값 선별
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

        // n과 m을 기준으로 8x8로 자른 후 칠해야 하는 색 선별
        for (int i = n - 8; i < n; i++) {
            for (int j = m - 8; j < m; j++) {
                // check == 1 -> 하얀색 칸인가?
                // check == 0 -> 검은색 칸인가?
                // check에 따라 저장된 값이 일치하는지 비교하고 그렇지 않으면 count++
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