import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n, m, count = 0;
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            LinkedList<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                // {초기 위치, 중요도}
                queue.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
            }

            count = 0;

            while (!queue.isEmpty()) {

                int[] front = queue.poll();
                boolean isMax = true;

                for (int i = 0; i < queue.size(); i++) {
                    if (front[1] < queue.get(i)[1]) {
                        queue.offer(front);
                        for (int j = 0; j < i; j++) { queue.offer(queue.poll()); }

                        isMax = false;
                        break;
                    }
                }

                if (isMax == false) continue;

                count++;
                if (front[0] == m) break;

            }
            bw.write(count + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

}