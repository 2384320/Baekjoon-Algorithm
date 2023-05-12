import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        PriorityQueue<int[]> spot = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            spot.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        st = new StringTokenizer(br.readLine());
        int city = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());

        while (fuel < city) {
            while (!spot.isEmpty() && spot.peek()[0] <= fuel) {
                fuels.add(spot.poll()[1]);
            }

            if (fuels.isEmpty()) {
                System.out.print(-1);
                return;
            }

            count++;
            fuel += fuels.poll();
        }

        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }
}