import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xa = Integer.parseInt(st.nextToken());
        int ya = Integer.parseInt(st.nextToken());
        int xb = Integer.parseInt(st.nextToken());
        int yb = Integer.parseInt(st.nextToken());
        int xc = Integer.parseInt(st.nextToken());
        int yc = Integer.parseInt(st.nextToken());

        double answer = -1.0;

        if ((xb - xa) * (yc - ya) != (xc - xa) * (yb - ya)) {
            double ab = getLength(xa, ya, xb, yb);
            double bc = getLength(xb, yb, xc, yc);
            double ca = getLength(xc, yc, xa, ya);

            double max = Math.max(ab, Math.max(bc, ca));
            double min = Math.min(ab, Math.min(bc, ca));
            answer = 2 * (max - min);
        }

        System.out.println(answer);
        br.close();
    }

    private static double getLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}