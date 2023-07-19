import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] arr = new boolean[10001];

        for (int i = 0; i < arr.length; i++) {
            int n = d(i);
            if (n < 10001) arr[n] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) bw.write(i + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int d(int num) {
        int sum = num;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}