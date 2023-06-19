import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dfs(new ArrayList<>(), 1, 0, n, m);

        br.close();
    }

    private static void dfs(List<Integer> list, int idx, int depth, int n, int m) {
        if (depth == m) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i <= n; i++) {
            list.add(i);
            dfs(list, i, depth + 1, n, m);
            list.remove(list.size() - 1);
        }
    }
}