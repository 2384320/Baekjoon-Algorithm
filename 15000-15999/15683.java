import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, answer, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        int[][] arr = new int[n][m];
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 6 || arr[i][j] == 0)
                    continue;
                list.add(new int[]{i, j});
            }
        }
        size = list.size();

        dfs(0, arr, list);

        System.out.println(answer);
        br.close();
    }

    private static void dfs(int depth, int[][] map, List<int[]> list) {
        if (depth == size) {
            answer = Math.min(answer, countZero(map));
            return;
        }

        int x = list.get(depth)[0];
        int y = list.get(depth)[1];
        int num = map[x][y];

        int[][] copyArr;
        if (num == 1) {
            copyArr = copyMap(map);
            observeRight(x, y, copyArr);
            dfs(depth + 1, copyArr, list);

            copyArr = copyMap(map);
            observeBottom(x, y, copyArr);
            dfs(depth + 1, copyArr, list);

            copyArr = copyMap(map);
            observeLeft(x, y, copyArr);
            dfs(depth + 1, copyArr, list);

            copyArr = copyMap(map);
            observeTop(x, y, copyArr);
            dfs(depth + 1, copyArr, list);
        } else if (num == 2) {
            copyArr = copyMap(map);
            observeRight(x, y, copyArr);
            observeLeft(x, y, copyArr);
            dfs(depth + 1, copyArr, list);

            copyArr = copyMap(map);
            observeBottom(x, y, copyArr);
            observeTop(x, y, copyArr);
            dfs(depth + 1, copyArr, list);
        } else if (num == 3) {
            copyArr = copyMap(map);
            observeRight(x, y, copyArr);
            observeBottom(x, y, copyArr);
            dfs(depth + 1, copyArr, list);

            copyArr = copyMap(map);
            observeBottom(x, y, copyArr);
            observeLeft(x, y, copyArr);
            dfs(depth + 1, copyArr, list);

            copyArr = copyMap(map);
            observeLeft(x, y, copyArr);
            observeTop(x, y, copyArr);
            dfs(depth + 1, copyArr, list);

            copyArr = copyMap(map);
            observeTop(x, y, copyArr);
            observeRight(x, y, copyArr);
            dfs(depth + 1, copyArr, list);
        } else if (num == 4) {
            copyArr = copyMap(map);
            observeRight(x, y, copyArr);
            observeBottom(x, y, copyArr);
            observeLeft(x, y, copyArr);
            dfs(depth + 1, copyArr, list);

            copyArr = copyMap(map);
            observeBottom(x, y, copyArr);
            observeLeft(x, y, copyArr);
            observeTop(x, y, copyArr);
            dfs(depth + 1, copyArr, list);

            copyArr = copyMap(map);
            observeLeft(x, y, copyArr);
            observeTop(x, y, copyArr);
            observeRight(x, y, copyArr);
            dfs(depth + 1, copyArr, list);

            copyArr = copyMap(map);
            observeTop(x, y, copyArr);
            observeRight(x, y, copyArr);
            observeBottom(x, y, copyArr);
            dfs(depth + 1, copyArr, list);
        } else if (num == 5) {
            copyArr = copyMap(map);
            observeTop(x, y, copyArr);
            observeBottom(x, y, copyArr);
            observeLeft(x, y, copyArr);
            observeRight(x, y, copyArr);
            dfs(depth + 1, copyArr, list);
        }
    }

    private static int[][] copyMap(int[][] arr) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    private static void observeTop(int x, int y, int[][] map) {
        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y] == 0)
                map[i][y] = -1;
            else if (map[i][y] == 6)
                break;
        }
    }

    private static void observeBottom(int x, int y, int[][] map) {
        for (int i = x + 1; i < n; i++) {
            if (map[i][y] == 0)
                map[i][y] = -1;
            else if (map[i][y] == 6)
                break;
        }
    }

    private static void observeLeft(int x, int y, int[][] map) {
        for (int i = y - 1; i >= 0; i--) {
            if (map[x][i] == 0)
                map[x][i] = -1;
            else if (map[x][i] == 6)
                break;
        }
    }

    private static void observeRight(int x, int y, int[][] map) {
        for (int i = y + 1; i < m; i++) {
            if (map[x][i] == 0)
                map[x][i] = -1;
            else if (map[x][i] == 6)
                break;
        }
    }

    private static int countZero(int[][] map) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }
}