import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    private static int answer, n, m;
    private static int[][] city;
    private static List<int[]> chicken;
    private static List<int[]> house;
    private static List<int[]> choice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        city = new int[n][n];
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        choice = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) house.add(new int[] {i, j});
                else if (city[i][j] == 2) chicken.add(new int[] {i, j});
            }
        }
        dfs(0, 0);

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int depth, int idx) {
        if (depth == m) {
            int sum = 0;
            for (int[] h : house) {
                int dist = Integer.MAX_VALUE;
                for (int[] c : choice) {
                    int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    dist = Math.min(dist, d);
                }
                sum += dist;
            }
            answer = Math.min(sum, answer);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            choice.add(new int[] {chicken.get(i)[0], chicken.get(i)[1]});
            dfs(depth + 1, i + 1);
            choice.remove(choice.size() - 1);
        }
    }
}