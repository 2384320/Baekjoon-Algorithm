import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int gcd = 0;
        for (int i = 0; i < n - 1; i++) {
            gcd = GCD(arr[i + 1] - arr[i], gcd);
        }
        bw.write((arr[n-1] - arr[0]) / gcd - n + 1 + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int GCD(int num1, int num2) {
        if (num2 == 0) return num1;
        return GCD(num2, num1%num2);
    }
}