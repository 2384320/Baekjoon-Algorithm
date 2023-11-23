import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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

    private static int r, c;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static Queue<Node> jqueue, fqueue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        jqueue = new LinkedList<>();
        fqueue = new LinkedList<>();

        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'J')
                    jqueue.offer(new Node(i, j));
                else if (arr[i][j] == 'F')
                    fqueue.offer(new Node(i, j));
            }
        }

        int answer = bfs(arr);
        System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
        br.close();
    }

    private static int bfs(char[][] arr) {
        int answer = 0;

        while (!jqueue.isEmpty()) {
            answer++;

            int size = fqueue.size();
            while (size-- > 0) {
                Node node = fqueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + node.x;
                    int ny = dy[i] + node.y;

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                    if (arr[nx][ny] == '#' || arr[nx][ny] == 'F') continue;
                    fqueue.offer(new Node(nx, ny));
                    arr[nx][ny] = 'F';
                }
            }

            size = jqueue.size();
            while (size-- > 0) {
                Node node = jqueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + node.x;
                    int ny = dy[i] + node.y;

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c)
                        return answer;
                    if (arr[nx][ny] == '.') {
                        jqueue.offer(new Node(nx, ny));
                        arr[nx][ny] = 'J';
                    }
                }
            }
        }
        return -1;
    }
}