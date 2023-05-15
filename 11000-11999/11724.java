import javax.lang.model.type.ArrayType;
        import java.io.*;
        import java.util.*;

public class Main {
    static int count;
    static boolean[] visited;
    static LinkedList<Integer>[] adjLink;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        count = 0;
        visited = new boolean[n+1];

        adjLink = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            adjLink[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            adjLink[num1].add(num2);
            adjLink[num2].add(num1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjLink[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) bfs(i);
        }

        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;

        while (!queue.isEmpty()) {
            num = queue.poll();

            Iterator<Integer> it = adjLink[num].iterator();

            while (it.hasNext()) {
                int i = it.next();
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        count++;
    }
}