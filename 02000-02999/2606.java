import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Integer>[] adj;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        adj = new LinkedList[n];
        visited = new boolean[n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList();
        }

        int com1, com2;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            com1 = Integer.parseInt(st.nextToken());
            com2 = Integer.parseInt(st.nextToken());
            adj[com1-1].add(com2);
            adj[com2-1].add(com1);
        }

        bfs(1);

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num-1] = true;

        while (!queue.isEmpty()) {
            num = queue.poll();

            Iterator<Integer> i = adj[num-1].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n-1]) {
                    visited[n-1] = true;
                    queue.add(n);
                    answer++;
                }
            }
        }
    }
}
/* dfs
import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Integer>[] adj;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        adj = new LinkedList[n];
        visited = new boolean[n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList();
        }

        int com1, com2;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            com1 = Integer.parseInt(st.nextToken());
            com2 = Integer.parseInt(st.nextToken());
            adj[com1-1].add(com2);
            adj[com2-1].add(com1);
        }

        dfs(1);

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num-1] = true;

        while (!queue.isEmpty()) {
            num = queue.poll();

            Iterator<Integer> i = adj[num-1].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n-1]) {
                    visited[n-1] = true;
                    answer++;
                    dfs(n);
                }
            }
        }
    }
}
*/