import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Spot {
        int x, y;

        Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            List<Spot> comvenis = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int homeX = Integer.parseInt(st.nextToken());
            int homeY = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int comveniX = Integer.parseInt(st.nextToken());
                int comveniY = Integer.parseInt(st.nextToken());

                comvenis.add(new Spot(comveniX, comveniY));
            }

            st = new StringTokenizer(br.readLine());
            int festivalX = Integer.parseInt(st.nextToken());
            int festivalY = Integer.parseInt(st.nextToken());

            if (bfs(homeX, homeY, festivalX, festivalY, comvenis))
                System.out.println("happy");
            else
                System.out.println("sad");
        }

        br.close();
    }

    private static boolean bfs(int homeX, int homeY, int festivalX, int festivalY, List<Spot> comvenis) {
        Queue<Spot> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(new Spot (homeX, homeY));

        while (!queue.isEmpty()) {
            Spot spot = queue.poll();
            int x = spot.x;
            int y = spot.y;

            if (Math.abs(x - festivalX) + Math.abs(y - festivalY) <= 1000)
                return true;

            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;

                int nx = comvenis.get(i).x;
                int ny = comvenis.get(i).y;

                if (Math.abs(x - nx) + Math.abs(y - ny) <= 1000) {
                    visited[i] = true;
                    queue.offer(new Spot(nx, ny));
                }
            }
        }
        return false;
    }
}