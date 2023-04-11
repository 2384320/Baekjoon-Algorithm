import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            bw.write(binary_search(num, 0, n-1) + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int binary_search(int num, int start, int end) {
        if (start > end) return 0;
        int mid = (start + end) / 2;

        if (num == arr[mid]) return 1;
        else if (num > arr[mid]) return binary_search(num, mid + 1, end);
        else return binary_search(num, start, mid - 1);
    }
}