import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] arr = new long[2][4];
        Point[] point = new Point[4];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
            arr[i][2] = Long.parseLong(st.nextToken());
            arr[i][3] = Long.parseLong(st.nextToken());
        }

        point[0] = new Point(arr[0][0], arr[0][1]);
        point[1] = new Point(arr[0][2], arr[0][3]);
        point[2] = new Point(arr[1][0], arr[1][1]);
        point[3] = new Point(arr[1][2], arr[1][3]);

        System.out.println(checkCCW(point));
        br.close();
    }

    private static int checkCCW(Point[] p) {
        boolean isAnswer = false;
        int answer = 0;

        int p123 = getCCW(p[0], p[1], p[2]);
        int p124 = getCCW(p[0], p[1], p[3]);
        int p341 = getCCW(p[2], p[3], p[0]);
        int p342 = getCCW(p[2], p[3], p[1]);

        boolean compare1 = Math.min(p[0].x, p[1].x) <= Math.max(p[2].x, p[3].x);
        boolean compare2 = Math.min(p[2].x, p[3].x) <= Math.max(p[0].x, p[1].x);
        boolean compare3 = Math.min(p[0].y, p[1].y) <= Math.max(p[2].y, p[3].y);
        boolean compare4 = Math.min(p[2].y, p[3].y) <= Math.max(p[0].y, p[1].y);

        if (p123 * p124 == 0 && p341 * p342 == 0) {
            isAnswer = true;
            if (compare1 && compare2 && compare3 && compare4)
                answer = 1;
        }
        if (p123 * p124 <= 0 && p341 * p342 <= 0) {
            if (!isAnswer)
                answer = 1;
        }
        return answer;
    }

    private static int getCCW(Point p1, Point p2, Point p3) {
        long result = ((p1.x * p2.y) + (p2.x * p3.y) + (p3.x * p1.y))
                - ((p1.x * p3.y) + (p2.x * p1.y) + (p3.x * p2.y));

        if (result > 0)
            return 1;
        else if (result < 0)
            return -1;
        else
            return 0;
    }
}