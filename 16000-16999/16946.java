import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] group;
    private static char[][] arr;
    private static Map<Integer, Integer> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        group = new int[n][m];
        arr = new char[n][m];
        hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '0' && group[i][j] == 0) {
                    hm.put(idx, bfs(i, j, idx));
                    idx++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(mapCount(i, j));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static int bfs(int x, int y, int idx) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;

        queue.offer(new int[] {x, y});
        group[x][y] = idx;

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (arr[nx][ny] == '1' || group[nx][ny] != 0) continue;
                queue.offer(new int[] {nx, ny});
                group[nx][ny] = idx;
                count++;
            }
        }
        return count;
    }

    private static int mapCount(int x, int y) {
        int sum = 1;
        HashSet<Integer> hs = new HashSet<>();
        if (arr[x][y] == '0') return 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (group[nx][ny] == 0 || arr[nx][ny] != '0') continue;
            hs.add(group[nx][ny]);
        }

        for (int i : hs)
            sum += hm.get(i);

        return sum % 10;
    }
}