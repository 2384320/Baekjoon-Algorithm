import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static String[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        visited = new boolean[n][n];
        map = new String[n][n];
        String mapOneLine;

        for (int i = 0; i < n; i++) {
            mapOneLine = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = mapOneLine.substring(j, j+1);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                if (map[i][j].equals("0")) continue;
                count = 0;
                dfs(i, j);
                list.add(count);
            }
        }

        Collections.sort(list);
        bw.write(list.size() + "");
        for (int i = 0; i < list.size(); i++) {
            bw.write("\n" + list.get(i));
        }

        bw.flush();
        br.close();
        bw.close();
    }
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX >= 0 && moveY >= 0 && moveX < n && moveY < n) {
                if (map[moveX][moveY].equals("1") && !visited[moveX][moveY]) dfs(moveX, moveY);
            }
        }
    }
}
/*
import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static String[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        visited = new boolean[n][n];
        map = new String[n][n];
        String mapOneLine;

        for (int i = 0; i < n; i++) {
            mapOneLine = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = mapOneLine.substring(j, j+1);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                if (map[i][j].equals("0")) continue;
                count = 0;
                bfs(i, j);
                list.add(count);
            }
        }

        Collections.sort(list);
        bw.write(list.size() + "");
        for (int i = 0; i < list.size(); i++) {
            bw.write("\n" + list.get(i));
        }

        bw.flush();
        br.close();
        bw.close();
    }
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[] {x, y});
        count++;

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX >= 0 && moveY >= 0 && moveX < n && moveY < n) {
                    if (map[moveX][moveY].equals("1") && !visited[moveX][moveY]) {
                        queue.add(new int[] {moveX, moveY});
                        visited[moveX][moveY] = true;
                        count++;
                    }
                }
            }
        }

    }
}
*/