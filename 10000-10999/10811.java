import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int i, j, temp;
        int[] arr = new int[n];
        for (int a = 0; a < n; a++) { arr[a] = a+1; }
        int[] reverseArr;

        for (int a = 0; a < m; a++) {
            reverseArr = Arrays.copyOfRange(arr, 0, arr.length);
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            for (int b = i - 1, c = j - 1; b < j; b++, c--) {
                if (i == j) break;
                arr[b] = reverseArr[c];
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