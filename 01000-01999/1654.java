import java.io.*;
import java.util.*;

public class Main {
    static int k, n, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int max = 0;
        arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }
        binary_search(0, max+1);

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void binary_search(int min, int max) {
        if (min >= max) {
            answer = min - 1;
            return;
        }

        int mid = (max + min) / 2;
        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            count += (arr[i] / mid);
        }

        if (count < n) binary_search(min, mid);
        else binary_search(mid + 1, max);
    }
}