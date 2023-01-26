import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, a, b, sum = 0, count = 0, result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        if (n == 0) {
            bw.write(1+"\n");
        } else {
            a = n / 10;
            b = n % 10;

            while(result != n) {
                sum = a + b;
                a = b;
                b = sum % 10;
                result = a * 10 + b;
                count++;
            }
            bw.write(count+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}