import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        boolean[] prime = new boolean[246913];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i*i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int count = 0;

            for (int i = n+1; i <= 2*n; i++) {
                if (!prime[i]) count++;
            }
            bw.write(count+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}