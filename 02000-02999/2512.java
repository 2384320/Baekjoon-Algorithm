import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long money = Integer.parseInt(br.readLine());
        long start = 0;
        long end = arr[n-1];
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int m : arr) {
                if (m >= mid) sum += mid;
                else sum += m;
            }

            if (sum > money) end = mid - 1;
            else {
                start = mid + 1;
                answer = Math.max(answer, mid);
            }
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}