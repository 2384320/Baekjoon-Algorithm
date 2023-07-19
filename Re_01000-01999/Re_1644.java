import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int n, answer, sum;
    private static boolean[] prime;
    private static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        sum = 0;
        prime = new boolean[n+1];
        list = new ArrayList<>();

        findPrime(n);
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) list.add(i);
        }

        binarySearch(0, 0);

        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static void findPrime(int num) {
        if (num < 2) return;
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j <= num; j += i) {
                prime[j] = true;
            }
        }
    }

    private static void binarySearch(int start, int end) {
        if (start > end) return;

        if (sum >= n) sum -= list.get(start++);
        else if (end == list.size()) return;
        else sum += list.get(end++);

        if (sum == n) answer++;

        binarySearch(start, end);
    }
}