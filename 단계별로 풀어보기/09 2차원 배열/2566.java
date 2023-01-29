import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] a = new int[9][9];
        int max = 0, row = 0, col = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] >= max) {
                    max = a[i][j];
                    row = i+1;
                    col = j+1;
                }
            }
        }
        bw.write(max+"\n"+row+" "+col+"");
        bw.flush();
        br.close();
        bw.close();
    }
}