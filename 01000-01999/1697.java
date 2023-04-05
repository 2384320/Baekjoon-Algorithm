import java.io.*;
import java.util.*;

public class Main {
    static int k, nx;
    static int[] visited = new int[100001];
    static int[] step = {-1, 1};
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs(n);

        bw.write(visited[k]-1 + "");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int x) {
        queue.add(x);
        visited[x] = 1;

        while (!queue.isEmpty()) {
            x = queue.poll();

            for (int i = 0; i < 3; i++) {
                if (i == 2) nx = x * 2;
                else nx = x + step[i];

                if (nx < 0 || nx > 100000) continue;
                else if (visited[nx] == 0) {
                    queue.add(nx);
                    visited[nx] = visited[x] + 1;
                }
                if (nx == k) return;
            }
        }
    }
}