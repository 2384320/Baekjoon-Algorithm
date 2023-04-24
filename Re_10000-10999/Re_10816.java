import java.io.*;
import java.util.*;

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
            int key = Integer.parseInt(st.nextToken());
            bw.write(upper(key) - lower(key) + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static int lower(int key) {
        int lower_b = 0;
        int upper_b = arr.length;

        while (lower_b != upper_b) {
            int mid = (lower_b + upper_b) / 2;
            if (arr[mid] >= key) upper_b = mid;
            else lower_b = mid + 1;
        }
        return lower_b;
    }

    public static int upper(int key) {
        int lower_b = 0;
        int upper_b = arr.length;

        while (lower_b != upper_b) {
            int mid = (lower_b + upper_b) / 2;
            if (arr[mid] > key) upper_b = mid;
            else lower_b = mid + 1;
        }
        return upper_b;
    }
}