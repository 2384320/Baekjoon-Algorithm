import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, max, min;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        arr = new int[n];
        int[] op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0], op);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }

    private static void dfs(int depth, int ans, int[] op) {
        if (depth == n) {
            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;

            op[i]--;
            switch(i) {
                case 0: dfs(depth + 1, ans + arr[depth], op); break;
                case 1: dfs(depth + 1, ans - arr[depth], op); break;
                case 2: dfs(depth + 1, ans * arr[depth], op); break;
                case 3: dfs(depth + 1, ans / arr[depth], op); break;
            }
            op[i]++;
        }
    }
}