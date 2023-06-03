import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int k = 0;
        int num = 0;

        for (int i = 1; i <= num1; i++) {
            if (num1 % i == 0) k++;
            if (num2 == k) {
                num = i;
                break;
            }
        }

        bw.write(num + "");
        bw.flush();
        br.close();
        bw.close();
    }
}