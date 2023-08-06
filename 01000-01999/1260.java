import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static LinkedList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        // 원소를 배열로 설정하여 연결된 정점을 담도록 함.
        adjList = new LinkedList[n+1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        // 방문 순서를 위해 오름차순으로 정렬함.
        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }
        dfs_list(v);
        bw.write("\n");
        visited = new boolean[n+1];
        bfs_list(v);

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs_list(int v) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        // 처음 시작하는 정점은 바로 방문 표시
        visited[v] = true;
        queue.add(v);

        while (queue.size() != 0) {
            // poll() 가장 뒤 원소 출력 후 삭제 -> 현재 위치한 곳 확인
            v = queue.poll();
            bw.write(v + " ");

            // 현재 위치한 정점과 연결된 정점 찾기
            Iterator<Integer> iter = adjList[v].listIterator();
            // 연결된 정점이 있으면 시작
            while (iter.hasNext()) {
                // 연결된 정점 w
                int w = iter.next();
                // w를 방문하지 않았으면 바로 이동하도록 함.
                // 만약 연결된 정점을 모두 방문했다면 poll()로 이미 삭제되었기 때문에
                // 전의 정점으로 넘어가서 다시 이 과정을 반복함.
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }
    
    public static void dfs_list(int v) throws IOException {
        visited[v] = true;
        bw.write(v + " ");

        Iterator<Integer> iter = adjList[v].listIterator();
        while (iter.hasNext()) {
            int w = iter.next();
            if (!visited[w]) dfs_list(w);
        }
    }
}