import java.io.*;
import java.util.*;

public class Main {
    public static int[] sorted = {};
    public static HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
    public static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        sorted = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(list, 0, n-1); // list 분할

        if (count.size() >= k) bw.write( count.get(k-1) + "");
        else bw.write(-1 + "");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void merge(int list[], int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = left;

        while (i <= mid && j <= right) {
            if (list[i] <= list[j]) sorted[k++] = list[i++];
            else sorted[k++] = list[j++];
        }

        if (i > mid) {
            for (int l = j; l <= right; l++) sorted[k++] = list[l];
        } else {
            for (int l = i; l <= mid; l++) sorted[k++] = list[l];
        }

        for (int l = left; l <= right; l++) {
            list[l] = sorted[l];
            count.put(index++, sorted[l]);
        }
    }

    public static void merge_sort(int list[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(list, left, mid); // list 분할 (왼쪽)
            merge_sort(list, mid + 1, right); // list 분할 (오른쪽)
            merge(list, left, mid, right); // list 정렬
        }
    }
}