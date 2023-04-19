import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static int[] arr;
    static boolean[] finished;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            answer = 0;
            arr = new int[n+1];
            finished = new boolean[n+1];
            visited = new boolean[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
            }

            for (int i = 1; i <= n; i++) {
                if (!finished[i]) dfs(i);
            }
            bw.write(n - answer + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int num) {
        visited[num] = true;
        int next = arr[num];

        if (!visited[next]) dfs(next);
        else {
            if (!finished[next]) {
                answer++;
                finished[next] = true;
                while (next != num) {
                    answer++;
                    next = arr[next];
                    finished[next] = true;
                }
            }
        }
        finished[num] = true;
    }
}