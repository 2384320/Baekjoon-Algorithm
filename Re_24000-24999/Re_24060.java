import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static int idx;
    private static int[] arr, sorted;
    private static HashMap<Integer, Integer> hm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        idx = 0;
        arr = new int[N];
        sorted = new int[N];
        hm = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N-1);

        int answer = -1;
        if (hm.size() >= K) answer = hm.get(K-1);

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        // 분할된 배열의 원소를 검사하며 인덱스를 올려감.
        // 결국 어느 한쪽이 먼저 경계를 넘어가게 될 것임.
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) sorted[k++] = arr[i++];
            else sorted[k++] = arr[j++];
        }

        // 만약 한쪽의 분할 배열의 원소가 먼저 정리된다면
        // 나머지 한 쪽에 정리하다 남은 원소를 마저 정리함.
        if (i > mid) {
            for (int l = j; l <= right; l++)
                sorted[k++] = arr[l];
        } else {
            for (int l = i; l <= mid; l++)
                sorted[k++] = arr[l];
        }

        // 다음 정렬을 위해 arr에 결과를 집어넣음.
        for (int l = left; l <= right; l++) {
            arr[l] = sorted[l];
            hm.put(idx++, sorted[l]);
        }
    }
}