import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            sb.append(bfs(before, after)).append("\n");
        }
        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static String bfs(int before, int after) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        String[] command = new String[10000];

        queue.add(before);
        visited[before] = true;
        Arrays.fill(command, "");

        while (!queue.isEmpty() && !visited[after]) {
            int num = queue.poll();

            int d = (2 * num) % 10000;
            int s = num == 0 ? 9999 : num - 1;
            int l = (num % 1000) * 10 + num / 1000;
            int r = (num % 10) * 1000 + num / 10;

            if (!visited[d]) {
                queue.add(d);
                visited[d] = true;
                command[d] = command[num] + "D";
            }

            if (!visited[s]) {
                queue.add(s);
                visited[s] = true;
                command[s] = command[num] + "S";
            }

            if (!visited[l]) {
                queue.add(l);
                visited[l] = true;
                command[l] = command[num] + "L";
            }

            if (!visited[r]) {
                queue.add(r);
                visited[r] = true;
                command[r] = command[num] + "R";
            }
        }
        return command[after];
    }
}