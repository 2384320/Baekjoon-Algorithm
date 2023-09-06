import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 1;
        int end = arr[n - 1] - arr[0] + 1;
        while (start < end) {
            int mid = (start + end) / 2;
            int wifiCount = installWifi(mid);

            if (wifiCount < c)
                end = mid;
            else
                start = mid + 1;
        }

        bw.write(start - 1 + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int installWifi(int dist) {
        int count = 1;
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dist) {
                count++;
                last = arr[i];
            }
        }
        return count;
    }
}