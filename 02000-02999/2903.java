import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int side = 2;

        for (int i = 0; i < n; i++) {
            side += (int)Math.pow(2, i);
        }

        bw.write(side*side + "");
        bw.flush();
        br.close();
        bw.close();
    }
}