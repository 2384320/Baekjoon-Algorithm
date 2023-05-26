import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int gcd = GCD(Math.max(m, n), Math.min(m, n));
            int lcm = m * n / gcd;

            boolean exist = false;
            int day = x;
            while (lcm >= day) {
                int countY = day % n == 0 ? n : day % n;
                if (countY == y) {
                    exist = true;
                    break;
                }
                day += m;
            }

            if (!exist) day = -1;
            bw.write(day + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int GCD(int num1, int num2) {
        if (num1 % num2 == 0) return num2;
        else return GCD(num2, num1%num2);
    }
}