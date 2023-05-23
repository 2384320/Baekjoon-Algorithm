import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int[] answer;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        answer = new int[3];
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0, n);
        bw.write(answer[0] + "\n" + answer[1] + "\n" + answer[2]);
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int row, int col, int size) {
        if (check(row, col, size)) {
            if (arr[row][col] == -1) answer[0]++;
            else if (arr[row][col] == 0) answer[1]++;
            else answer[2]++;
            return;
        }

        int newSize = size / 3;

        bfs(row, col, newSize);
        bfs(row + newSize, col, newSize);
        bfs(row + 2 * newSize, col, newSize);

        bfs(row, col + newSize, newSize);
        bfs(row + newSize, col + newSize, newSize);
        bfs(row + 2 * newSize, col + newSize, newSize);

        bfs(row, col + 2 * newSize, newSize);
        bfs(row + newSize, col + 2 * newSize, newSize);
        bfs(row + 2 * newSize, col + 2 * newSize, newSize);
    }

    public static boolean check(int row, int col, int size) {
        int num = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (num != arr[i][j]) return false;
            }
        }

        return true;
    }
}