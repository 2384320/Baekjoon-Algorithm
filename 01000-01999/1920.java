import java.io.*;
import java.util.*;

import static java.lang.Float.NaN;

public class Main {
    public static int[] nArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        nArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);

        int m = Integer.parseInt(br.readLine());
        int x;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            x = Integer.parseInt(st.nextToken());

            bw.write(binary_search(x) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    public static int binary_search(int num) {
        int start = 0;
        int end = nArr.length-1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (num == nArr[mid]) return 1;
            else if (num > nArr[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }
}