import java.io.*;
import java.util.*;

public class Main {
    static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리 수
        int m = Integer.parseInt(st.nextToken()); // 뱀 수
        board = new int[101];

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        bw.write(bfs(1) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int bfs(int spot) {
        int[] visited = new int[101];
        visited[spot] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(spot);

        while (!queue.isEmpty()) {
            spot = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int moveSpot = spot + i;

                if (moveSpot > 100) continue;

                if (visited[board[moveSpot]] == 0) {
                    queue.offer(board[moveSpot]);
                    visited[board[moveSpot]] = visited[spot] + 1;
                }
                if (board[moveSpot] == 100) return visited[100];
            }
        }
        return visited[100];
    }
}