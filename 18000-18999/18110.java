import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(score);

        // n명의 인원에서 15%에 해당하는 수
        int exclude = (int)Math.round(n * 0.01 * 15);

        double sum = 0;
        for (int i = exclude; i < score.length - exclude; i++) {
            sum += score[i];
        }

        int answer = (int)Math.round(sum / (score.length - 2 * exclude));
        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}