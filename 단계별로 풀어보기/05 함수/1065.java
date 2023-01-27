import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[n+1];
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int x = d(i);
            count[i] = x;
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] == 1) sum++;
        }
        bw.write(sum + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
    static int d(int number) {
        int result = 0;
        if (number < 100) result = 1;
        else if (number == 1000) result = 0;
        else {
            int num1 = number / 100;
            int num2 = number / 10 % 10;
            int num3 = number % 10;
            if (num1 - num2 == num2 - num3) result = 1;
            else result = 0;
        }
        return result;
    }
}