import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n - 1;

        int num1 = arr[start];
        int num2 = arr[end];
        int min = Integer.MAX_VALUE;
        while (start < end) {
            int num = arr[start] + arr[end];

            if (Math.abs(num) <= min) {
                num1 = arr[start];
                num2 = arr[end];
                min = Math.abs(num);
            }

            if (num > 0) end--;
            else if (num < 0) start++;
            else break;
        }

        bw.write(num1 + " " + num2);
        br.close();
        bw.flush();
        bw.close();
    }
}