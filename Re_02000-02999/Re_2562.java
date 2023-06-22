import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] a = new int[9];
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < 9; i++) {
            a[i] = Integer.parseInt(br.readLine());
            if (max < a[i]) {
                count = i + 1;
                max = a[i];
            }
        }
        bw.write(max + "\n" + count);
        br.close();
        bw.flush();
        bw.close();
    }
}