import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static char[][] front, back, right, left, up, down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            front = new char[][]{{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}};
            back = new char[][]{{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}};
            right = new char[][]{{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}};
            left = new char[][]{{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'}};
            up = new char[][]{{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}};
            down = new char[][]{{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'}};

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String command = st.nextToken();
                char side = command.charAt(0);
                char direction = command.charAt(1);

                switch (side) {
                    case 'F': spinF(direction); break;
                    case 'B': spinB(direction); break;
                    case 'L': spinL(direction); break;
                    case 'R': spinR(direction); break;
                    case 'U': spinU(direction); break;
                    case 'D': spinD(direction); break;
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(up[i][j]);
                }
                System.out.println();
            }
        }
        br.close();
    }

    private static void spinU(char direction) {
        if (direction == '+') {
            up = clockwise(up);
            char[] tmp = front[0].clone();
            front[0] = right[0].clone();
            right[0] = back[0].clone();
            back[0] = left[0].clone();
            left[0] = tmp;
        } else {
            up = counterClockwise(up);
            char[] tmp = front[0].clone();
            front[0] = left[0].clone();
            left[0] = back[0].clone();
            back[0] = right[0].clone();
            right[0] = tmp;
        }
    }

    private static void spinD(char direction) {
        if (direction == '+') {
            down = clockwise(down);
            char[] tmp = front[2].clone();
            front[2] = left[2].clone();
            left[2] = back[2].clone();
            back[2] = right[2].clone();
            right[2] = tmp;

        } else {
            down = counterClockwise(down);
            char[] tmp = front[2].clone();
            front[2] = right[2].clone();
            right[2] = back[2].clone();
            back[2] = left[2].clone();
            left[2] = tmp;
        }
    }

    private static void spinL(char direction) {
        if (direction == '+') {
            left = clockwise(left);

            char[] tmp = new char[3];
            for (int i = 0; i < 3; i++) {
                tmp[i] = front[2 - i][0];
            }

            for (int i = 0; i < 3; i++) {
                front[i][0] = up[i][0];
            }

            for (int i = 0; i < 3; i++) {
                up[i][0] = back[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                back[i][2] = down[i][2];
            }

            for (int i = 0; i < 3; i++) {
                down[i][2] = tmp[i];
            }
        } else {
            left = counterClockwise(left);

            char[] tmp = new char[3];
            for (int i = 0; i < 3; i++) {
                tmp[i] = front[i][0];
            }

            for (int i = 0; i < 3; i++) {
                front[i][0] = down[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                down[i][2] = back[i][2];
            }

            for (int i = 0; i < 3; i++) {
                back[i][2] = up[2 - i][0];
            }

            for (int i = 0; i < 3; i++) {
                up[i][0] = tmp[i];
            }
        }
    }

    private static void spinR(char direction) {
        if (direction == '+') {
            right = clockwise(right);

            char[] tmp = new char[3];
            for (int i = 0; i < 3; i++) {
                tmp[i] = up[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                up[i][2] = front[i][2];
            }

            for (int i = 0; i < 3; i++) {
                front[i][2] = down[2 - i][0];
            }

            for (int i = 0; i < 3; i++) {
                down[i][0] = back[i][0];
            }

            for (int i = 0; i < 3; i++) {
                back[i][0] = tmp[i];
            }
        } else {
            right = counterClockwise(right);

            char[] tmp = new char[3];
            for (int i = 0; i < 3; i++) {
                tmp[i] = up[i][2];
            }

            for (int i = 0; i < 3; i++) {
                up[i][2] = back[2 - i][0];
            }

            for (int i = 0; i < 3; i++) {
                back[i][0] = down[i][0];
            }

            for (int i = 0; i < 3; i++) {
                down[i][0] = front[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                front[i][2] = tmp[i];
            }
        }
    }

    private static void spinF(char direction) {
        if (direction == '+') {
            front = clockwise(front);
            char[] tmp = new char[3];
            for (int i = 0; i < 3; i++) {
                tmp[i] = up[2][i];
            }

            for (int i = 0; i < 3; i++) {
                up[2][i] = left[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                left[i][2] = down[2][2 - i];
            }

            for (int i = 0; i < 3; i++) {
                down[2][i] = right[i][0];
            }

            for (int i = 0; i < 3; i++) {
                right[i][0] = tmp[i];
            }
        } else {
            front = counterClockwise(front);

            char[] tmp = new char[3];
            for (int i = 0; i < 3; i++) {
                tmp[i] = up[2][2 - i];
            }

            for (int i = 0; i < 3; i++) {
                up[2][i] = right[i][0];
            }

            for (int i = 0; i < 3; i++) {
                right[i][0] = down[2][i];
            }

            for (int i = 0; i < 3; i++) {
                down[2][i] = left[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                left[i][2] = tmp[i];
            }
        }
    }

    private static void spinB(char direction) {
        if (direction == '+') {
            back = clockwise(back);

            char[] tmp = new char[3];
            for (int i = 0; i < 3; i++) {
                tmp[i] = up[0][2 - i];
            }

            for (int i = 0; i < 3; i++) {
                up[0][i] = right[i][2];
            }

            for (int i = 0; i < 3; i++) {
                right[i][2] = down[0][i];
            }

            for (int i = 0; i < 3; i++) {
                down[0][i] = left[2 - i][0];
            }

            for (int i = 0; i < 3; i++) {
                left[i][0] = tmp[i];
            }
        } else {
            back = counterClockwise(back);

            char[] tmp = new char[3];
            for (int i = 0; i < 3; i++) {
                tmp[i] = up[0][i];
            }

            for (int i = 0; i < 3; i++) {
                up[0][i] = left[2 - i][0];
            }

            for (int i = 0; i < 3; i++) {
                left[i][0] = down[0][2 - i];
            }

            for (int i = 0; i < 3; i++) {
                down[0][i] = right[i][2];
            }

            for (int i = 0; i < 3; i++) {
                right[i][2] = tmp[i];
            }
        }
    }

    private static char[][] clockwise(char[][] side) {
        char[][] spin = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                spin[i][j] = side[2 - j][i];
            }
        }
        return spin;
    }

    private static char[][] counterClockwise(char[][] side) {
        char[][] spin = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                spin[i][j] = side[j][2 - i];
            }
        }
        return spin;
    }
}