import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int MAX_VALUE = 1_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[MAX_VALUE];
        isPrime[1] = true;

        for (int i = 2; i < Math.sqrt(MAX_VALUE); i++) {
            if (isPrime[i]) continue;
            for (int j = i * i; j < MAX_VALUE; j+=i) {
                isPrime[j] = true;
            }
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;

            for (int i = 2; i <= n / 2; i++) {
                if (isPrime[i]) continue;

                if (!isPrime[n - i])
                    answer++;
            }
            System.out.println(answer);
        }
        br.close();
    }
}