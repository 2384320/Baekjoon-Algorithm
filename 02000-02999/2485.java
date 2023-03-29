import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int gcd = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (i == 0) continue;
            gcd = GCD(arr[i] - arr[i-1], gcd);
        }
        bw.write((arr[n-1] - arr[0]) / gcd + 1 - n +"");

        bw.flush();
        br.close();
        bw.close();
    }
    public static int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a%b);
    }
}