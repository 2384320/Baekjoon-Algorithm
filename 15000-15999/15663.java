import java.io.*;
import java.util.*;

public class Main {
    private static HashSet<String> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        answer = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(n, m, arr, 0, new ArrayList<>());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dfs(int n, int m, int[] arr, int depth, List<Integer> list) {
        if (depth == m) {
            String str = "";
            for (int idx : list) {
                str += arr[idx] + " ";
            }
            if (!answer.contains(str)) {
                answer.add(str);
                System.out.println(str);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (list.contains(i)) continue;
            list.add(i);
            dfs(n, m, arr, depth + 1, list);
            list.remove(list.size() - 1);
        }
    }
}