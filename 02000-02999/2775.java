import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            bw.write(test(k, n) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static int test(int k, int n) {
        if (k == 0) return n;
        else if (n == 1) return 1;
        else return test(k-1, n) + test(k, n-1);
    }

}