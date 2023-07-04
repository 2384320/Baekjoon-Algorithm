import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] sudoku;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);

        br.close();
        //bw.flush();
        //bw.close();
    }

    private static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++)  {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (!isPossible(row, col, i)) continue;
                sudoku[row][col] = i;
                dfs(row, col + 1);
            }
            sudoku[row][col] = 0;
            return;
        }
        dfs(row, col + 1);
    }

    private static boolean isPossible(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == num) return false;
            if (sudoku[i][col] == num) return false;
        }
        int setRow = (row / 3) * 3;
        int setCol = (col / 3) * 3;
        for (int i = setRow; i < setRow + 3; i++) {
            for (int j = setCol; j < setCol + 3; j++) {
                if (sudoku[i][j] == num) return false;
            }
        }

        return true;
    }
}