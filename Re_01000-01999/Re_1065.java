import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (i < 100) sum++;
            else if (i == 1000) continue;
            else {
                int num1 = i / 100;
                int num2 = i / 10 % 10;
                int num3 = i % 10;
                if (num1 - num2 == num2 - num3) sum++;
            }
        }

        bw.write(sum + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}