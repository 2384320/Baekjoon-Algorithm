import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long left = 0L;
        long right = (long) arr[0] * m;

        long ans = 0L;
        while (left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += (mid / arr[i]);
            }

            if (cnt >= m) {
                ans = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }

        System.out.println(ans);
        br.close();
    }
}