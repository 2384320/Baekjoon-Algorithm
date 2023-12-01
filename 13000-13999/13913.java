import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 100_001;
    private static int[] arr, next;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[SIZE];
        next = new int[SIZE];
        bfs(n, k);

        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int idx = k;
        while (idx != n) {
            stack.push(next[idx]);
            idx = next[idx];
        }

        System.out.print(arr[k] - 1 + " ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        br.close();
    }

    private static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        arr[n] = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == k)
                return;

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) nx = x + 1;
                else if (i == 1) nx = x - 1;
                else nx = x * 2;

                if (nx < 0 || nx >= SIZE) continue;
                if (arr[nx] == 0) {
                    queue.offer(nx);
                    arr[nx] = arr[x] + 1;
                    next[nx] = x;
                }
            }
        }
    }
}