import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static long min, max;
    private static boolean[] isNoNo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());
        isNoNo = new boolean[(int)(max - min + 1)];
        checkNoNo();

        int answer = 0;
        for (boolean b : isNoNo) {
            if (!b) answer++;
        }

        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static void checkNoNo() {
        for (long l = 2; l * l <= max; l++) {
            long pow = l * l;
            long start = min % pow == 0 ? min / pow : min / pow + 1;

            for (long n = start; n * pow <= max; n++) {
                isNoNo[(int)(n * pow - min)] = true;
            }
        }
    }
}