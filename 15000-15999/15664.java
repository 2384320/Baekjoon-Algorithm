import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] arr;
    private static HashSet<String> hs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        hs = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0, new int[m]);

        br.close();
    }

    private static void dfs(int depth, int idx, int[] num) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int nn : num) {
                sb.append(nn).append(" ");
            }

            if (!hs.contains(sb.toString())) {
                hs.add(sb.toString());
                System.out.println(sb);
            }
            return;
        }

        for (int i = idx; i < n; i++) {
            num[depth] = arr[i];
            dfs(depth + 1, i + 1, num);
        }
    }
}