import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                StringTokenizer st = new StringTokenizer(br.readLine());
                double x1 = Double.parseDouble(st.nextToken());
                double y1 = Double.parseDouble(st.nextToken());
                double x2 = Double.parseDouble(st.nextToken());
                double y2 = Double.parseDouble(st.nextToken());
                double x3 = Double.parseDouble(st.nextToken());
                double y3 = Double.parseDouble(st.nextToken());

                double d = 2 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
                double x = getSpotX(x1, y1, x2, y2, x3, y3, d);
                double y = getSpotY(x1, y1, x2, y2, x3, y3, d);
                double answer = Math.pow((Math.pow(x - x1, 2) + Math.pow(y - y1, 2)), 0.5) * 2 * 3.141592653589793;
                System.out.printf("%.2f", answer);
                System.out.println();
            } catch (NullPointerException e) {
                break;
            }
        }

        br.close();
    }

    private static double getSpotX(double x1, double y1, double x2, double y2, double x3, double y3, double d) {
        return ((Math.pow(x1, 2) + Math.pow(y1, 2)) * (y2 - y3) + (Math.pow(x2, 2) + Math.pow(y2, 2)) * (y3 - y1) + (Math.pow(x3, 2) + Math.pow(y3, 2)) * (y1 - y2)) / d;
    }

    private static double getSpotY(double x1, double y1, double x2, double y2, double x3, double y3, double d) {
        return ((Math.pow(x1, 2) + Math.pow(y1, 2)) * (x3 - x2) + (Math.pow(x2, 2) + Math.pow(y2, 2)) * (x1 - x3) + (Math.pow(x3, 2) + Math.pow(y3, 2)) * (x2 - x1)) / d;
    }
}