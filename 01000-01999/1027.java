import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            double tmp = 0;

            for (int j = i - 1; j > 0; j--) {
                double s = (double) (arr[j] - arr[i]) / (j - i);
                if (j == i - 1 || tmp > s) {
                    count++;
                    tmp = s;
                }
            }

            for (int j = i + 1; j <= n; j++) {
                double s = (double) (arr[j] - arr[i]) / (j - i);
                if (j == i + 1 || tmp < s) {
                    count++;
                    tmp = s;
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
        br.close();
    }
}