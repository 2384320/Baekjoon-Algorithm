import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final int RANGE = 2_000_001;
    private static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        isPrime = new boolean[RANGE];
        findPrime();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long num1 = Long.parseLong(st.nextToken());
            long num2 = Long.parseLong(st.nextToken());

            long sum = num1 + num2;
            String command;
            if (sum < 4) command = "NO";
            else if (sum % 2 == 0) command = "YES";
            else {
                if (check(sum - 2)) command = "YES";
                else command = "NO";
            }
            bw.write(command + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void findPrime() {
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i < RANGE; i++) {
            if (isPrime[i]) continue;
            for (int j = i * 2; j < RANGE; j+=i) {
                isPrime[j] = true;
            }
        }
    }

    private static boolean check(long num) {
        if (num <= RANGE) return !isPrime[(int)num];

        for (int i = 0; i < RANGE; i++) {
            if (isPrime[i]) continue;
            if (num % i == 0) return false;
        }
        return true;
    }
}