import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int r, c;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static Node[] swans;
    private static char[][] arr;
    private static boolean[][] visited;
    private static Queue<Node> queue;
    private static Queue<Node> waterQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        swans = new Node[2];
        arr = new char[r][c];
        visited = new boolean[r][c];
        queue = new LinkedList<>();
        waterQueue = new LinkedList<>();

        int idx = 0;
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'L') {
                    swans[idx++] = new Node(i, j);
                    arr[i][j] = '.';
                }

                if (arr[i][j] == '.')
                    waterQueue.offer(new Node(i, j));
            }
        }
        queue.offer(swans[0]);
        visited[swans[0].x][swans[0].y] = true;

        int time = 0;
        while (!move()) {
            melt();
            time++;
        }

        System.out.println(time);
        br.close();
    }

    private static boolean move() {
        Queue<Node> q = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.x == swans[1].x && now.y == swans[1].y) return true;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (arr[nx][ny] == '.')
                    queue.offer(new Node(nx, ny));
                else if (arr[nx][ny] == 'X')
                    q.offer(new Node(nx, ny));
            }
        }
        queue = q;
        return false;
    }

    private static void melt() {
        int size = waterQueue.size();
        for (int i = 0; i < size; i++) {
            Node now = waterQueue.poll();

            for (int j = 0; j < 4; j++) {
                int nx = now.x + dx[j];
                int ny = now.y + dy[j];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (arr[nx][ny] == 'X') {
                    arr[nx][ny] = '.';
                    waterQueue.offer(new Node (nx, ny));
                }
            }
        }
    }
}