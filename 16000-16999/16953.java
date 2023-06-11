import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(bfs(a, b) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static long bfs(int start, int end) {
        long count = 1;
        Queue<long[]> queue = new LinkedList<>();
        long min = Integer.MAX_VALUE;
        queue.offer(new long[] {start, count});

        while (!queue.isEmpty()) {
            long num = queue.peek()[0];
            count = queue.peek()[1];
            queue.poll();

            if (num > end) continue;
            if (num == end) {
                min = Math.min(min, count);
                continue;
            }

            long plusOne = num * 10L + 1;
            long mulTwo = num * 2L;
            queue.offer(new long[] {plusOne, count + 1});
            queue.offer(new long[] {mulTwo, count + 1});
        }
        if (min != Integer.MAX_VALUE) return min;
        return -1;
    }
}