import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result = Integer.MAX_VALUE;
    static int[][] city;
    static List<int[]> home = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> choice = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        city = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
				// city에서 나온 값 중 집의 좌표와 치킨집의 좌표는 따로 저장함.
                if (city[i][j] == 1) home.add(new int[] {i, j});
                else if (city[i][j] == 2) chicken.add(new int[] {i, j});
            }
        }

        dfs(0, 0);

        bw.write(result + "");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int depth, int idx) {
        if (depth == m) {
            int sum = 0;
			// 집을 기준으로 가장 가까운 치킨 거리를 가진 값을 추출함.
            for (int[] h : home) {
                int min = Integer.MAX_VALUE;
                for (int[] c : choice) {
                    int distance = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    min = Math.min(distance, min);
                }
                sum += min;
            }
			// 도시의 치킨 거리가 전에 검색한 값보다 작으면 그 값을 사용함.
            result = Math.min(sum, result);
        }

        for (int i = idx; i < chicken.size(); i++) {
						choice.add(chicken.get(i));
            dfs(depth + 1, i + 1);
            choice.remove(chicken.get(i));
        }
    }
}