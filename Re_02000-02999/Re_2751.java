import java.io.*;

public class Main {
    static int[] sorted;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sorted = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(0, n-1);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void merge_sort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(left, mid);
            merge_sort(mid + 1, right);

            int p = left;
            int q = mid + 1;
            int idx = p;

            while (p <= mid && q <= right) {
                if (arr[p] <= arr[q]) sorted[idx++] = arr[p++];
                else sorted[idx++] = arr[q++];
            }

            if (p > mid) {
                for (int i = q; i <= right; i++) {
                    sorted[idx++] = arr[i];
                }
            } else {
                for (int i = p; i <= mid; i++) {
                    sorted[idx++] = arr[i];
                }
            }

            for (int i = left; i <= right; i ++) {
                arr[i] = sorted[i];
            }
        }
    }
}