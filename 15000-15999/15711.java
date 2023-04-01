import java.io.*;
import java.util.*;

public class Main {
    static boolean[] prime = new boolean[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        long a, b, sum;
        StringTokenizer st;
        String answer = "";

        isPrime();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            sum = a + b;

            if (sum < 4) answer = "NO";
            else if (sum % 2 == 0) answer = "YES";
            else {
                if (check(sum - 2)) answer = "YES";
                else answer = "NO";
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean check(long num) {
        if (num <= 2000000) return !prime[(int)num];

        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) continue;
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void isPrime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= 2000000; i++) {
            if (prime[i]) continue;
            for (int j = i * 2; j <= 2000000; j+=i) {
                prime[j] = true;
            }
        }
    }
}