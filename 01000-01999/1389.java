import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] result, visited;
    static int[][] friendMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        result = new int[n+1];
        friendMap = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            friendMap[num1][num2] = 1;
            friendMap[num2][num1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i < result.length; i++) {
            if (min > result[i]) {
                answer = i;
                min = result[i];
            }
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new int[n+1];
        queue.add(num);

        while (!queue.isEmpty()) {
            int people = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (friendMap[people][i] == 1 && visited[i] == 0 && i != num) {
                    queue.add(i);
                    visited[i] = visited[people] + 1;
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[num] += visited[i];
        }
    }
}