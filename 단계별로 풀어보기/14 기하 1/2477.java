import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int orientalMelonCount = Integer.parseInt(br.readLine());
        int[][] field = new int[6][2];
        int area = 0, max = 0, rectangle;

        StringTokenizer st = new StringTokenizer(br.readLine());
        field[0][0] = Integer.parseInt(st.nextToken());
        field[0][1] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            field[i][0] = Integer.parseInt(st.nextToken());
            field[i][1] = Integer.parseInt(st.nextToken());
            rectangle = field[i-1][1] * field[i][1];
            max = Math.max(max, rectangle);
            area += rectangle;
        }
        rectangle = field[0][1] * field[5][1];
        max = Math.max(max, rectangle);
        area += rectangle;

        bw.write((area - max * 2) * orientalMelonCount + "");
        bw.flush();
        br.close();
        bw.close();
    }
}