import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Delivery implements Comparable<Delivery> {
        int start, end, count;

        Delivery(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }

        @Override
        public int compareTo(Delivery o) {
            if (this.end == o.end)
                return this.start - o.start;
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            deliveries.add(new Delivery(start, end, count));
        }

        Collections.sort(deliveries);

        int[] weight = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = c;
        }

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            Delivery d = deliveries.get(i - 1);

            int max = Integer.MAX_VALUE;

            for (int j = d.start; j < d.end; j++) {
                max = Math.min(max, weight[j]);
            }

            if (max >= d.count) {
                for (int j = d.start; j < d.end; j++) {
                    weight[j] -= d.count;
                }
                answer += d.count;
            } else {
                for (int j = d.start; j < d.end; j++) {
                    weight[j] -= max;
                }
                answer += max;
            }
        }
        System.out.println(answer);
        br.close();
    }
}