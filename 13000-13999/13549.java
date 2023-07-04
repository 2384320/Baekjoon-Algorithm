import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    private static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        check = new int[100001];
        Arrays.fill(check, -1);

        bfs(n, k);
        bw.write(check[k]+ "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(x);
        check[x] = 0;

        while (!queue.isEmpty()) {
            x = queue.poll();

            if (x == k) return;

            int runPlus = x + 1;
            int runMinus = x - 1;
            int teleport = 2 * x;

            if (teleport <= 100000 && check[teleport] == -1) {
                queue.addFirst(teleport);
                check[teleport] = check[x];
            }
            if (x > 0 && check[runMinus] == -1) {
                queue.offer(runMinus);
                check[runMinus] = check[x] + 1;
            }
            if (x < 100000 && check[runPlus] == -1) {
                queue.offer(runPlus);
                check[runPlus] = check[x] + 1;
            }
        }
    }
}