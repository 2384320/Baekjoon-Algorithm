import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static int n;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int problem = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] arr = new int[n][n];
            int[][] move = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                Arrays.fill(move[i], Integer.MAX_VALUE);
            }

            System.out.println("Problem " + problem + ": " + bfs(arr, move));
            problem++;
        }
        br.close();
    }

    private static int bfs(int[][] arr, int[][] move) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0, arr[0][0]));
        move[0][0] = arr[0][0];

        while (!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            int cost = queue.peek().cost;
            queue.poll();

            if (x == n - 1 && y == n - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (cost + arr[nx][ny] < move[nx][ny]) {
                    move[nx][ny] = cost + arr[nx][ny];
                    queue.offer(new Node(nx, ny, cost + arr[nx][ny]));
                }
            }
        }
        return -1;
    }
}