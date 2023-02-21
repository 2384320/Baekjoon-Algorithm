import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum = 0, count = 0, num = 0;

        for (int i = 0; i < n; i++) {
            num = i;
            sum = i;

            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            
            if (sum == n) {
                count = i;
                break;
            }
        }

        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }
}