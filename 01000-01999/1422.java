import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int repeat = n-k;
        String[] arr = new String[k];
        StringBuilder answer = new StringBuilder();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            arr[i] = br.readLine();
            max = Math.max(max, Integer.parseInt(arr[i]));
        }

        Arrays.sort(arr, ((o1, o2) -> -(o1+o2).compareTo(o2+o1)));

        int idx = 0;
        while (k-- > 0) {
            if (Integer.parseInt(arr[idx]) == max) {
                for (int i = 0; i <= repeat; i++) {
                    answer.append(arr[idx]);
                    max = -1;
                }
            }
            else answer.append(arr[idx]);
            idx++;
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}