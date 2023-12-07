import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static boolean[][] arr;
    private static List<Node>[][] switchRoom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][n];
        switchRoom = new List[n][n];
        arr[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switchRoom[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            switchRoom[x1][y1].add(new Node(x2, y2));
        }

        System.out.println(bfs() + 1);
        br.close();
    }

    private static int bfs() {
        Deque<Node> deque = new ArrayDeque<>();
        int count = 0;
        boolean switchOn = false;
        boolean[][] visited = new boolean[n][n];

        deque.offerLast(new Node(0, 0));

        while (!deque.isEmpty()) {
            Node node = deque.removeFirst();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (!arr[nx][ny] || visited[nx][ny]) continue;
                deque.offerLast(new Node(nx, ny));
                visited[nx][ny] = true;
            }

            for (Node nxt : switchRoom[node.x][node.y]) {
                if (!arr[nxt.x][nxt.y]) {
                    switchOn = true;
                    arr[nxt.x][nxt.y] = true;
                    count++;
                }
            }
        }

        if (switchOn)
            return count + bfs();
        return count;
    }
}