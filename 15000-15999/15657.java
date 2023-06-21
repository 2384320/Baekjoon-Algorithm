import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(new ArrayList<>(), 0, 0, n, m, arr);

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(List<Integer> list, int depth, int idx, int n, int m, int[] arr) {
        if (depth == m) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < n; i++) {
            list.add(arr[i]);
            dfs(list, depth + 1, i, n, m, arr);
            list.remove(list.size() - 1);
        }
    }

}