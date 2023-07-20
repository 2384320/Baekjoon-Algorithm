import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());

        while (c-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] score = new int[n];
            int sum = 0;
            int count = 0;

            for (int j = 0; j < n; j++) {
                score[j] = Integer.parseInt(st.nextToken());
                sum += score[j];
            }

            int avg = sum / n;
            for (int j = 0; j < n; j++) {
                if (score[j] > avg) count++;
            }
            bw.write(String.format("%.3f", (double)count/(double)n * 100.0) + "%" + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}