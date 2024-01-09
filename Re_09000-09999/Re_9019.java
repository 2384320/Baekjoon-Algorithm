import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(bfs(a, b));
        }
        br.close();
    }

    private static String bfs(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        String[] command = new String[10000];
        boolean[] visited = new boolean[10000];

        queue.offer(a);
        visited[a] = true;
        Arrays.fill(command, "");

        while (!queue.isEmpty() && !visited[b]) {
            int num = queue.poll();

            int d = (2 * num) % 10000;
            int s = num == 0 ? 9999 : num - 1;
            int l = (num % 1000) * 10 + num / 1000;
            int r = (num % 10) * 1000 + num / 10;

            if (!visited[d]) {
                queue.offer(d);
                visited[d] = true;
                command[d] = command[num] + "D";
            }

            if (!visited[s]) {
                queue.offer(s);
                visited[s] = true;
                command[s] = command[num] + "S";
            }

            if (!visited[l]) {
                queue.offer(l);
                visited[l] = true;
                command[l] = command[num] + "L";
            }

            if (!visited[r]) {
                queue.offer(r);
                visited[r] = true;
                command[r] = command[num] + "R";
            }
        }

        return command[b];
    }
}