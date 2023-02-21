import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        boolean[][] white_paper = new boolean[101][101];
        int result = 0;

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            for (int j = row; j < row+10; j++) {
                for (int k = col; k < col+10; k++) {
                    white_paper[j][k] = true;
                }
            }
        }

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (white_paper[i][j]) result++;
            }
        }

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}