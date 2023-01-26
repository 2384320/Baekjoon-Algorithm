import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] spot = new int[3][2];
        int x = 0, y = 0;

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            spot[i][0] = Integer.parseInt(st.nextToken());
            spot[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (spot[i][0] == spot[j][0]) x = spot[3-i-j][0];
                if (spot[i][1] == spot[j][1]) y = spot[3-i-j][1];
            }
        }

        bw.write(x + " " + y);
        bw.flush();
        br.close();
        bw.close();
    }
}