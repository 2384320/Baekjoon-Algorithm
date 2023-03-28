import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] sudoku = new int[9][9];
    static boolean[] checkNum;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
    }

    public static void dfs(int row, int col) throws IOException {
        // 맨 밑까지 도달했으면 옆 줄로 옮겨감.
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        // 맨 오른쪽까지 왔으면 출력 진행.
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(sudoku[i][j] + " ");
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            br.close();
            System.exit(0);
        }

        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, col, i)) {
                    // i를 입력하는 것이 가능하기 때문에 빈칸에 i 입력
                    sudoku[row][col] = i;
                    // 다음 칸으로 넘어감.
                    dfs(row, col + 1);
                }
            }
            // i를 입력하는 것이 불가능 하다면 값이 잘못됐다는 뜻으로
            // 빈칸으로 남기고 전 단계로 돌아감.
            sudoku[row][col] = 0;
            return;
        }
        // 지금 칸의 값이 0이 아닌 경우 다음으로 넘어감.
        dfs(row, col + 1);
    }

    public static boolean possibility(int row, int col, int value) {
        // 가로줄과 세로줄에 같은 값이 있는지 없는지 검증
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == value) return false;
            if (sudoku[i][col] == value) return false;
        }

        // 3x3 판에 같은 값이 있는지 없는지 검증
        // 없다면 true 반환
        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (sudoku[i][j] == value) return false;
            }
        }

        return true;
    }

}