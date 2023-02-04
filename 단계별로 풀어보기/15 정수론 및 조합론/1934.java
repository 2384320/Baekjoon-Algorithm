import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int num1, num2, gcd;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            gcd = GCD(Math.max(num1, num2), Math.min(num1, num2));
            bw.write(num1 * num2 / gcd + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static int GCD(int num1, int num2) throws IOException {
        if (num1 % num2 == 0) return num2;
        else return GCD(num2, num1 % num2);
    }
}