import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char[] chArr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = chArr[j] - '0';
            }
        }

        quad(0, 0, n);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void quad(int x, int y, int size) {
        if (checkTree(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        int newSize = size / 2;
        sb.append("(");
        quad(x, y, newSize);
        quad(x, y + newSize, newSize);
        quad(x + newSize, y, newSize);
        quad(x + newSize, y + newSize, newSize);
        sb.append(")");
    }

    public static boolean checkTree(int x, int y, int size) {
        int num = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (num != arr[i][j]) return false;
            }
        }
        return true;
    }
}