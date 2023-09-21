import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] score = {1, 2, 4, 8};
    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[4][8];
        for (int i = 0; i < 4; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sequence = Integer.parseInt(st.nextToken()) - 1;
            int rotation = Integer.parseInt(st.nextToken());

            int[] isRotation = new int[4];
            isRotation[sequence] = rotation;

            for (int j = sequence - 1; j >= 0; j--) {
                if (arr[j][2] != arr[j + 1][6]) {
                    if (isRotation[j + 1] == 1)
                        isRotation[j] = -1;
                    else if (isRotation[j + 1] == -1)
                        isRotation[j] = 1;
                } else
                    break;
            }

            for (int j = sequence + 1; j < 4; j++) {
                if (arr[j][6] != arr[j - 1][2]) {
                    if (isRotation[j - 1] == 1)
                        isRotation[j] = -1;
                    else if (isRotation[j - 1] == -1)
                        isRotation[j] = 1;
                } else
                    break;
            }

            for (int j = 0; j < 4; j++) {
                if (isRotation[j] == 0)
                    continue;

                rotationCogwheel(isRotation[j], j);
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == '1')
                answer += score[i];
        }
        System.out.println(answer);
        br.close();
    }

    private static void rotationCogwheel(int rotation, int sequence) {
        char ch = arr[sequence][0];

        if (rotation == 1) {
            for (int j = 1; j < 8; j++) {
                char temp = arr[sequence][j];
                arr[sequence][j] = ch;
                ch = temp;
            }
        } else if (rotation == -1) {
            for (int j = 7; j > 0; j--) {
                char temp = arr[sequence][j];
                arr[sequence][j] = ch;
                ch = temp;
            }
        }
        arr[sequence][0] = ch;
    }
}