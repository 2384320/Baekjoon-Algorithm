import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(factorial(n) / (factorial(k) * factorial(n - k)) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int factorial(int num) {
        int facNum;
        
        if (num == 0) facNum = 1;
        else facNum = num;
        
        for (int i = num-1; i > 1; i--) {
            facNum *= i;
        }
        return facNum;
    }
}