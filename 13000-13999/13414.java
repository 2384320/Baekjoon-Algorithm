import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int answer = 0;
        int totalWeight = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            if (!queue.isEmpty()) {
                while (true) {
                    if (queue.size() == w)
                        totalWeight -= queue.poll();
                    else {
                        if (totalWeight + a <= l) {
                            queue.offer(a);
                            totalWeight += a;
                            answer++;
                            break;
                        } else {
                            queue.offer(0);
                            answer++;
                        }
                    }
                }
            } else {
                queue.offer(a);
                totalWeight += a;
                answer++;
            }
        }
        System.out.println(answer + w);
        br.close();
    }
}