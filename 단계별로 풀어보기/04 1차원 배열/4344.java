import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int c = Integer.parseInt(br.readLine());


        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] score = new int[n];
            int sum = 0, avg = 0, count = 0;

            for (int j = 0; j < n; j++) {
                score[j] = Integer.parseInt(st.nextToken());
                sum += score[j];
            }
            avg = sum / n;
            for (int j = 0; j < n; j++) {
                if (score[j] > avg) count++;
            }
            bw.write(String.format("%.3f", (double)count/(double)n*100.0) + "%" + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}