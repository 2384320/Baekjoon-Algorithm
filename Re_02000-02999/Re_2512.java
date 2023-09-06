import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        int start = 0;
        int end = arr[n - 1];
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            for (int a : arr)
                sum += Math.min(a, mid);

            if (m >= sum) {
                answer = Math.max(answer, mid);
                start = mid + 1;
            } else
                end = mid - 1;
        }

        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }
}