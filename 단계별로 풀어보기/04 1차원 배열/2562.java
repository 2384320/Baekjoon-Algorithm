import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int max = 0, count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a[] = new int[9];

        for (int i = 0; i < 9; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 9; i++) {
            if (a[i] >= max) {
                max = a[i];
                count = i + 1;
            }
        }
        bw.write(max + "\n");
        bw.write(count + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}