import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static long l;
    static long answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            k = Math.max(arr[i], k);
        }
        binary_search(0, k);

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void binary_search(long min, long max) {
        if (min >= max) {
            answer = min - 1;
            return;
        }

        long mid = (max + min) / 2;
        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            l = arr[i] - mid >= 0 ? arr[i] - mid : 0;
            count += l;
        }

        if (count < m) binary_search(min, mid);
        else binary_search(mid + 1, max);
    }
}