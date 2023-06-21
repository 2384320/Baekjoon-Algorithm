import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> listN = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listN.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(listN);

        dfs(listN, new ArrayList<>(), 0, n, m);

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(List<Integer> listN, List<Integer> list, int depth, int n, int m) {
        if (depth == m) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (list.contains(listN.get(i))) continue;
            list.add(listN.get(i));
            dfs(listN, list, depth + 1, n, m);
            list.remove(list.size() - 1);
        }
    }
}