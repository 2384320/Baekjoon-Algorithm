import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double max = 0, sum = 0;
        int n = Integer.parseInt(br.readLine());
        double a[] = new double[n];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] >= max) max = a[i];
        }

        for (int i = 0; i < n; i++) {
            a[i] = a[i] / max * 100;
            sum += a[i];
        }
        bw.write(sum/(double)n + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}