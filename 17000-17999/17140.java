import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int xLength, yLength;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        xLength = 3;
        yLength = 3;

        int[][] arr = new int[101][101];
        for (int i = 1; i <= xLength; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= yLength; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time <= 100) {
            if (arr[r][c] == k)
                break;

            if (xLength >= yLength) {
                for (int i = 1; i <= xLength; i++) {
                    R(i, arr);
                }
            } else {
                for (int i = 1; i <= yLength; i++) {
                    C(i, arr);
                }
            }
            time++;
        }

        if (time > 100)
            time = -1;
        System.out.println(time);
        br.close();
    }

    private static void R(int idx, int[][] arr) {
        PriorityQueue<Count> pq = new PriorityQueue<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 1; i <= yLength; i++) {
            if (arr[idx][i] == 0)
                continue;
            count.put(arr[idx][i], count.getOrDefault(arr[idx][i], 0) + 1);
        }
        count.forEach((k, v) -> pq.add(new Count(k, v)));

        int i = 1;
        while (!pq.isEmpty()) {
            Count c = pq.poll();
            arr[idx][i++] = c.number;
            arr[idx][i++] = c.count;
        }

        yLength = Math.max(yLength, i);

        while (i <= 99) {
            arr[idx][i++] = 0;
        }
    }

    private static void C(int idx, int[][] arr) {
        PriorityQueue<Count> pq = new PriorityQueue<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 1; i <= xLength; i++) {
            if (arr[i][idx] == 0)
                continue;
            count.put(arr[i][idx], count.getOrDefault(arr[i][idx], 0) + 1);
        }
        count.forEach((k, v) -> pq.add(new Count(k, v)));

        int i = 1;
        while (!pq.isEmpty()) {
            Count c = pq.poll();
            arr[i++][idx] = c.number;
            arr[i++][idx] = c.count;
        }

        xLength = Math.max(xLength, i);

        while (i <= 99) {
            arr[i++][idx] = 0;
        }
    }
}

class Count implements Comparable<Count> {
    int number, count;

    Count(int number, int count) {
        this.number = number;
        this.count = count;
    }

    @Override
    public int compareTo(Count o) {
        if (this.count == o.count)
            return this.number - o.number;
        return this.count - o.count;
    }
}