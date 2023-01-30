import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr_n;
    static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr_n = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr_n[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr_n);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (binary_search(num, 0, n-1)) bw.write("1 ");
            else bw.write("0 ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean binary_search(int num, int start, int end) {
        if (start > end) return false;

        int mid = (start + end) / 2;

        if (num == arr_n[mid]) return true;
        else if (num > arr_n[mid]) return binary_search(num, mid + 1, end);
        else return binary_search(num, start, mid - 1);
    }
}