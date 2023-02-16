import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long count5 = five_power_n(n) - five_power_n(n - m) - five_power_n(m);
        long count2 = two_power_n(n) - two_power_n(n - m) - two_power_n(m);

        bw.write(Math.min(count5, count2) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static long five_power_n(long num) {
        int count = 0;
        while (num >= 5) {
            count += (num / 5);
            num /= 5;
        }
        return count;
    }

    static long two_power_n(long num) {
        int count = 0;
        while (num >= 2) {
            count += (num / 2);
            num /= 2;
        }
        return count;
    }
}