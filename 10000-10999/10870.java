import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num1 = 0, num2 = 1, num3 = 0;

        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                num3 = num1 + num2;
                num1 = num2;
                num2 = num3;
            }
        } else if (n == 1) {
            num3 = num2;
        } else num3 = num1;

        bw.write(num3+"");
        bw.flush();
        br.close();
        bw.close();
    }
}