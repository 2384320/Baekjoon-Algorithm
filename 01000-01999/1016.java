import java.io.*;
import java.util.*;

public class Main {
    static Long min, max;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());

        int answer = 0;

        check = new boolean[(int)(max - min + 1)];
        checkNoNo();
        for (boolean i : check) {
            if (!i) answer++;
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
    public static void checkNoNo() {
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start = min % pow == 0 ? min / pow : min / pow + 1;

            for (long j = start; j * pow <= max; j++) {
                check[(int)(j * pow - min)] = true;
            }
        }
    }
}