import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[] arr = new String[k];
        int max = 0;

        for (int i = 0; i < k; i++) {
            arr[i] = br.readLine();
            max = Math.max(Integer.parseInt(arr[i]), max);
        }

        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int repeat = n - k + 1;
        while (k-- > 0) {
            if (Integer.parseInt(arr[idx]) == max) {
                sb.append(arr[idx].repeat(Math.max(0, repeat)));
                max = -1;
            } else
                sb.append(arr[idx]);
            idx++;
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}