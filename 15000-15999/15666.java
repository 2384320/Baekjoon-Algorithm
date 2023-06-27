import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[] arr, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        dfs(0, 0, sb);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    private static void dfs(int idx, int depth, StringBuilder sb) {
        if (depth == m) {
            for (int r : result) {
                sb.append(r).append(" ");
            }
            sb.append("\n");
            return;
        }

        int num = 0;
        for (int i = idx; i < n; i++) {
            if (num == arr[i]) continue;
            result[depth] = arr[i];
            dfs(i, depth + 1, sb);
            num = arr[i];
        }
    }
}