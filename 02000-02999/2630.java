import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int[] color;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        color = new int[2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cut(0, 0, n, n);
        bw.write(color[0] + "\n" + color[1]);
        bw.flush();
        br.close();
        bw.close();
    }

    public static void cut(int startX, int startY, int endX, int endY) {
        int colorInt = paper[startX][startY];
        boolean check = true;

        x: for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (paper[i][j] != colorInt) {
                    check = false;
                    break x;
                }
            }
        }

        if (!check) {
            cut(startX, startY, (startX+endX)/2, (startY+endY)/2);
            cut((startX+endX)/2, (startY+endY)/2, endX, endY);
            cut((startX+endX)/2, startY, endX, (startY+endY)/2);
            cut(startX, (startY+endY)/2, (startX+endX)/2, endY);
        } else color[colorInt]++;
    }
}