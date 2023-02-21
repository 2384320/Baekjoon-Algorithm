import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int i, j, k, value, mid;
        List<Integer> list = new ArrayList<>();
        for (int a = 0; a < n; a++) { list.add(a+1); }

        for (int a = 0; a < m; a++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            mid = list.get(k-1);

            while (list.get(i-1) != mid) {
                value = list.get(j-1);
                list.remove(j-1);
                list.add(i-1, value);
            }
        }

        for (int a = 0; a < n; a++) {
            bw.write(list.get(a) + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}