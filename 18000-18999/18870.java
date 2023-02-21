import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), index = 0;
        int[] arr = new int[n], sort_arr = new int[n];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = sort_arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sort_arr);

        for (int sa : sort_arr) {
            if (!hm.containsKey(sa)) {
                hm.put(sa, index);
                index++;
            }
        }

        for (int key : arr) {
            bw.write(hm.get(key)+" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}