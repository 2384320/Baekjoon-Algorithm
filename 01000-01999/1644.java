import java.io.*;
import java.util.*;

public class Main {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum, answer = 0;
        prime = new boolean[n+1];
        isPrime(n);

        for (int i = 2; i <= n; i++) {
            if (prime[i]) continue;
            sum = 0;
            for (int j = i; j <= n; j++) {
                if (prime[j]) continue;
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }
                else if (sum > n) break;
            }
        }
        bw.write(answer + "");
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

/*
import java.io.*;
import java.util.*;

public class Main {
    static boolean[] prime;
    static int sum = 0, answer = 0, n;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        prime = new boolean[n+1];
        isPrime(n);

        for (int i = 2; i <= n; i++) {
            if (!prime[i]) list.add(i);
        }

        binary_search(0, 0);

        bw.write(answer + "");
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

    public static void binary_search(int start, int end) {
        if (start > end) return;

        if (sum >= n) {
            sum -= list.get(start++);
        } else if (end == list.size()) return;
        else sum += list.get(end++);

        if (n == sum) answer++;

        binary_search(start, end);
    }
}
*/