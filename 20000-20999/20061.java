import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int score;
    private static boolean[][] green, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        score = 0;

        green = new boolean[6][4];
        blue = new boolean[4][6];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (t == 1)
                moveOneOneBlock(x, y);
            else if (t == 2)
                moveOneTwoBlock(x, y);
            else if (t == 3)
                moveTwoOneBlock(x, y);

            getScore();
            checkSpecial();


            System.out.println("green " + i);
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.print(green[j][k] + " ");
                }
                System.out.println();
            }

            System.out.println("blue " + i);
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 6; k++) {
                    System.out.print(blue[j][k] + " ");
                }
                System.out.println();
            }
        }

        System.out.println(score);
        System.out.println(count());
        br.close();
    }

    private static void moveOneOneBlock(int x, int y) {
        boolean alreadyExist = false;
        for (int i = 1; i < 6; i++) {
            if (green[i][y]) {
                alreadyExist = true;
                green[i - 1][y] = true;
                break;
            }
        }
        if (!alreadyExist)
            green[5][y] = true;

        alreadyExist = false;
        for (int i = 1; i < 6; i++) {
            if (blue[x][i]) {
                alreadyExist = true;
                blue[x][i - 1] = true;
                break;
            }
        }
        if (!alreadyExist)
            blue[x][5] = true;
    }

    private static void moveOneTwoBlock(int x, int y) {
        boolean alreadyExist = false;
        for (int i = 1; i < 6; i++) {
            if (green[i][y] || green[i][y + 1]) {
                alreadyExist = true;
                green[i - 1][y] = true;
                green[i - 1][y + 1] = true;
                break;
            }
        }
        if (!alreadyExist) {
            green[5][y] = true;
            green[5][y + 1] = true;
        }

        alreadyExist = false;
        for (int i = 1; i < 6; i++) {
            if (blue[x][i]) {
                alreadyExist = true;
                blue[x][i - 1] = true;
                blue[x][i - 2] = true;
                break;
            }
        }
        if (!alreadyExist) {
            blue[x][5] = true;
            blue[x][4] = true;
        }
    }

    private static void moveTwoOneBlock(int x, int y) {
        boolean alreadyExist = false;
        for (int i = 1; i < 6; i++) {
            if (green[i][y]) {
                alreadyExist = true;
                green[i - 1][y] = true;
                green[i - 2][y] = true;
                break;
            }
        }
        if (!alreadyExist) {
            green[5][y] = true;
            green[4][y] = true;
        }

        alreadyExist = false;
        for (int i = 1; i < 6; i++) {
            if (blue[x][i] || blue[x + 1][i]) {
                alreadyExist = true;
                blue[x][i - 1] = true;
                blue[x + 1][i - 1] = true;
                break;
            }
        }
        if (!alreadyExist) {
            blue[x][5] = true;
            blue[x + 1][5] = true;
        }
    }

    private static void getScore() {
        for (int i = 5; i >= 2; i--) {
            boolean isFull = true;
            for (int j = 0; j < 4; j++) {
                if (!green[i][j]) {
                    isFull = false;
                    break;
                }
            }

            if (isFull) {
                score++;
                resetGreenZeroLine(i);
                i++;
            }
        }

        for (int i = 5; i >= 2; i--) {
            boolean isFull = true;
            for (int j = 0; j < 4; j++) {
                if (!blue[j][i]) {
                    isFull = false;
                    break;
                }
            }

            if (isFull) {
                score++;
                resetBlueZeroLine(i);

                i++;
            }
        }
    }

    private static void resetGreenZeroLine(int start) {
        for (int i = start; i > 0; i--) {
            green[i] = green[i - 1];
        }

        green[0][0] = false;
        green[0][1] = false;
        green[0][2] = false;
        green[0][3] = false;
    }

    private static void resetBlueZeroLine(int start) {
        for (int i = start; i > 0; i--) {
            blue[0][i] = blue[0][i - 1];
            blue[1][i] = blue[1][i - 1];
            blue[2][i] = blue[2][i - 1];
            blue[3][i] = blue[3][i - 1];
        }

        blue[0][0] = false;
        blue[1][0] = false;
        blue[2][0] = false;
        blue[3][0] = false;
    }

    private static void checkSpecial() {
        while (checkGreenOneLine()) {
            resetGreenZeroLine(5);
        }

        while (checkBlueOneLine()) {
            resetBlueZeroLine(5);
        }
    }

    private static boolean checkGreenOneLine() {
        for (int i = 0; i < 4; i++) {
            if (green[1][i]) return true;
        }
        return false;
    }

    private static boolean checkBlueOneLine() {
        for (int i = 0; i < 4; i++) {
            if (blue[i][1]) return true;
        }
        return false;
    }

    private static int count() {
        int blockCount = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (green[i][j])
                    blockCount++;
                if (blue[j][i])
                    blockCount++;
            }
        }
        return blockCount;
    }
}