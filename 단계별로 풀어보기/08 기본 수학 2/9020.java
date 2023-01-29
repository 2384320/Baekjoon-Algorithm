import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[10001];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i*i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int num1 = n / 2;
            int num2 = n / 2;

            while (true) {
                if (!prime[num1] && !prime[num2]) {
                    bw.write(num1 + " " + num2 + "\n");
                    break;
                }
                num1--;
                num2++;
            }

        }

        bw.flush();
        br.close();
        bw.close();
    }
}