import java.io.*;
import java.util.*;

public class Main {
    static int start, end;
    static boolean[] visited;
    static ArrayList<Node>[] adjLink;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        adjLink = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjLink[i] = new ArrayList<>();
        }

        // 다리마다의 중량제한의 최댓값과 최솟값을 저장
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            max = Math.max(max, cost);
            min = Math.min(min, cost);
            adjLink[x].add(new Node(y, cost));
            adjLink[y].add(new Node(x, cost));
        }
        
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        while (min <= max) {
            // 최댓값과 최솟값으로 중간값을 생성함.
            int mid = (min + max) / 2;
            // 중간값을 생성할 때마다 visited 배열을 초기화시킴.
            visited = new boolean[n + 1];

            // 시작점부터 시작하여 도착점까지 도달할 수 있냐를 체크함.
            // 문제에서 주어지는 입력값은 무조건 시작점과 도착점이 이어져 있다고 했으니
            // bfs()에서는 다음의 중량으로 통과할 수 있는지를 따짐.
            // 통과할 수 있다면 최소 중량을 mid + 1하여 mid 값을 올리고
            // 통과할 수 없다면 최대 중량을 mid - 1하여 mid 값을 내림.
            // 이때 answer는 통과할 수 있는 상황에 결정되도록 함.
            if (bfs(mid)) {
                min = mid + 1;
                answer = mid;
            } else max = mid - 1;
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean bfs(int mid) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            if (temp == end) return true;

            for (int i = 0; i < adjLink[temp].size(); i++) {
                // 중량제한은 중간값보다 크거나 같아야 함.
                if (adjLink[temp].get(i).cost >= mid && !visited[adjLink[temp].get(i).n]) {
                    visited[adjLink[temp].get(i).n] = true;
                    queue.offer(adjLink[temp].get(i).n);
                }
            }
        }
        return false;
    }
}

class Node {
    int n;
    int cost;

    public Node(int n, int cost) {
        this.n = n;
        this.cost = cost;
    }
}