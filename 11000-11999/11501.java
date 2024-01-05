import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long answer = 0;
            int[] arr = new int[n];
            int[] max = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int m = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (m < arr[i])
                    m = arr[i];
                max[i] = m;
            }

            for (int i = 0; i < n; i++) {
                if (max[i] > arr[i])
                    answer += (max[i] - arr[i]);
            }
            System.out.println(answer);
        }
        br.close();
    }
}