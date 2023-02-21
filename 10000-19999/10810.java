import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int i, j, k;
        int[] arr = new int[n];
        for (int a = 0; a < m; a++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            for (int b = i - 1; b < j; b++) {
                arr[b] = k;
            }
        }

        for (int a = 0; a < n; a++) {
            bw.write(arr[a] + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}