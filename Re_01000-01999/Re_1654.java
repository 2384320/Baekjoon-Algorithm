import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = arr[k - 1];
        while (start < end) {
            int mid = (start + end) / 2;
            int count = 0;

            for (int i = 0; i < k; i++) {
                count += (arr[i] / mid);
            }

            if (count < n) end = mid;
            else start = mid + 1;
        }

        bw.write(start - 1 + "");
        br.close();
        bw.flush();
        bw.close();
    }
}