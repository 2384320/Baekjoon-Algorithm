import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int gcd = GCD(num1, num2);

        bw.write(gcd + "\n" + num1 * num2 / gcd);
        bw.flush();
        br.close();
        bw.close();
    }

    public static int GCD(int num1, int num2) {
        if (num1 % num2 == 0) return num2;
        else return GCD(num2, num1 % num2);
    }
}