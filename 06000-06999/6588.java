import java.io.*;
import java.util.*;

public class Main {
    static boolean[] prime = new boolean[1000001];
    static boolean check = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        isPrime(1000000);

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            for (int i = 2; i <= n/2; i++) {
                if (!prime[i] && !prime[n-i]) { // i + n - i = n -> 이 두 값이 소수인지만 알면 됨.
                    bw.write(n + " = " + i + " + " + (n-i) + "\n");
                    check = false;
                    break;
                }
            }
            if (check) bw.write("Goldbach's conjecture is wrong.");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void isPrime(int num) {
        if (num < 2) return;
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (prime[i]) continue;
            for (int j = i*i; j <= num; j += i) {
                prime[j] = true;
            }
        }
    }
}