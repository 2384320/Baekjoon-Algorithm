import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static char[][] cubeU, cubeD, cubeF, cubeB, cubeL, cubeR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] spin = br.readLine().split(" ");

            cubeU = new char[][]{{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}};
            cubeD = new char[][]{{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'}};
            cubeF = new char[][]{{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}};
            cubeB = new char[][]{{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}};
            cubeL = new char[][]{{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'}};
            cubeR = new char[][]{{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}};

            for (int i = 0; i < n; i++) {
                char side = spin[i].charAt(0);
                char direction = spin[i].charAt(1);

                switch (side) {
                    case 'U': rotateU(direction); break;
                    case 'D': rotateD(direction); break;
                    case 'F': rotateF(direction); break;
                    case 'B': rotateB(direction); break;
                    case 'L': rotateL(direction); break;
                    case 'R': rotateR(direction); break;
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(cubeU[i][j]);
                }
                System.out.println();
            }
        }
        br.close();
    }

    private static void rotateU(char direction) {
        if (direction == '+') {
            cubeU = clockwise(cubeU);
            char[] tmp = cubeB[0].clone();
            cubeB[0] = cubeL[0].clone();
            cubeL[0] = cubeF[0].clone();
            cubeF[0] = cubeR[0].clone();
            cubeR[0] = tmp;
        } else {
            cubeU = counterclockwise(cubeU);
            char[] tmp = cubeB[0].clone();
            cubeB[0] = cubeR[0].clone();
            cubeR[0] = cubeF[0].clone();
            cubeF[0] = cubeL[0].clone();
            cubeL[0] = tmp;
        }
    }

    private static void rotateD(char direction) {
        if (direction == '+') {
            cubeD = clockwise(cubeD);
            char[] tmp = cubeB[2].clone();
            cubeB[2] = cubeR[2].clone();
            cubeR[2] = cubeF[2].clone();
            cubeF[2] = cubeL[2].clone();
            cubeL[2] = tmp;
        } else {
            cubeD = counterclockwise(cubeD);
            char[] tmp = cubeB[2].clone();
            cubeB[2] = cubeL[2].clone();
            cubeL[2] = cubeF[2].clone();
            cubeF[2] = cubeR[2].clone();
            cubeR[2] = tmp;
        }
    }

    private static void rotateF(char direction) {
        if (direction == '+') {
            cubeF = clockwise(cubeF);
            char[] tmp = new char[3];

            for (int i = 0; i < 3; i++) {
                tmp[i] = cubeU[2][i];
            }

            for (int i = 0; i < 3; i++) {
                cubeU[2][i] = cubeL[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                cubeL[i][2] = cubeD[2][2 - i];
            }

            for (int i = 0; i < 3; i++) {
                cubeD[2][i] = cubeR[i][0];
            }

            for (int i = 0; i < 3; i++) {
                cubeR[i][0] = tmp[i];
            }
        } else {
            cubeF = counterclockwise(cubeF);
            char[] temp = new char[3];

            for (int i = 0; i < 3; i++) {
                temp[i] = cubeU[2][2 - i];
            }

            for (int i = 0; i < 3; i++) {
                cubeU[2][i] = cubeR[i][0];
            }

            for (int i = 0; i < 3; i++) {
                cubeR[i][0] = cubeD[2][i];
            }

            for (int i = 0; i < 3; i++) {
                cubeD[2][i] = cubeL[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                cubeL[i][2] = temp[i];
            }
        }
    }

    private static void rotateB(char direction) {
        if (direction == '+') {
            cubeB = clockwise(cubeB);
            char[] temp = new char[3];

            for (int i = 0; i < 3; i++) {
                temp[i] = cubeU[0][2 - i];
            }

            for (int i = 0; i < 3; i++) {
                cubeU[0][i] = cubeR[i][2];
            }

            for (int i = 0; i < 3; i++) {
                cubeR[i][2] = cubeD[0][i];
            }

            for (int i = 0; i < 3; i++) {
                cubeD[0][i] = cubeL[2 - i][0];
            }

            for (int i = 0; i < 3; i++) {
                cubeL[i][0] = temp[i];
            }
        } else {
            cubeB = counterclockwise(cubeB);
            char[] temp = new char[3];

            for (int i = 0; i < 3; i++) {
                temp[i] = cubeU[0][i];
            }

            for (int i = 0; i < 3; i++) {
                cubeU[0][i] = cubeL[2 - i][0];
            }

            for (int i = 0; i < 3; i++) {
                cubeL[i][0] = cubeD[0][2 - i];
            }

            for (int i = 0; i < 3; i++) {
                cubeD[0][i] = cubeR[i][2];
            }

            for (int i = 0; i < 3; i++) {
                cubeR[i][2] = temp[i];
            }
        }
    }

    private static void rotateL(char direction) {
        if (direction == '+') {
            cubeL = clockwise(cubeL);
            char[] temp = new char[3];

            for (int i = 0; i < 3; i++) {
                temp[i] = cubeU[i][0];
            }

            for (int i = 0; i < 3; i++) {
                cubeU[i][0] = cubeB[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                cubeB[i][2] = cubeD[i][2];
            }

            for (int i = 0; i < 3; i++) {
                cubeD[i][2] = cubeF[2 - i][0];
            }

            for (int i = 0; i < 3; i++) {
                cubeF[i][0] = temp[i];
            }
        } else {
            cubeL = counterclockwise(cubeL);
            char[] temp = new char[3];

            for (int i = 0; i < 3; i++) {
                temp[i] = cubeU[2 - i][0];
            }

            for (int i = 0; i < 3; i++) {
                cubeU[i][0] = cubeF[i][0];
            }

            for (int i = 0; i < 3; i++) {
                cubeF[i][0] = cubeD[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                cubeD[i][2] = cubeB[i][2];
            }

            for (int i = 0; i < 3; i++) {
                cubeB[i][2] = temp[i];
            }
        }
    }

    private static void rotateR(char direction) {
        if (direction == '+') {
            cubeR = clockwise(cubeR);
            char[] temp = new char[3];

            for (int i = 0; i < 3; i++) {
                temp[i] = cubeU[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                cubeU[i][2] = cubeF[i][2];
            }

            for (int i = 0; i < 3; i++) {
                cubeF[i][2] = cubeD[2 - i][0];
            }

            for (int i = 0; i < 3; i++) {
                cubeD[i][0] = cubeB[i][0];
            }

            for (int i = 0; i < 3; i++) {
                cubeB[i][0] = temp[i];
            }
        } else {
            cubeR = counterclockwise(cubeR);
            char[] temp = new char[3];

            for (int i = 0; i < 3; i++) {
                temp[i] = cubeU[i][2];
            }

            for (int i = 0; i < 3; i++) {
                cubeU[i][2] = cubeB[2 - i][0];
            }

            for (int i = 0; i < 3; i++) {
                cubeB[i][0] = cubeD[i][0];
            }

            for (int i = 0; i < 3; i++) {
                cubeD[i][0] = cubeF[2 - i][2];
            }

            for (int i = 0; i < 3; i++) {
                cubeF[i][2] = temp[i];
            }
        }
    }

    private static char[][] clockwise(char[][] arr) {
        char[][] rotate = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rotate[i][j] = arr[3 - j - 1][i];
            }
        }
        return rotate;
    }

    private static char[][] counterclockwise(char[][] arr) {
        char[][] rotate = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rotate[i][j] = arr[j][3 - i - 1];
            }
        }
        return rotate;
    }
}