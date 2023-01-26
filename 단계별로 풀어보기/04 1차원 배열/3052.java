import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a[] = new int[10];
        int count = 10;

        for (int i = 0; i < 10; i++) {
            int b = Integer.parseInt(br.readLine());
            a[i] = b % 42;
        }

        a = Arrays.stream(a).distinct().toArray();

        bw.write(a.length + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}