import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            String answer = "no";
            if (isRightAngledTriangle(a, b, c) || isRightAngledTriangle(b, c, a) || isRightAngledTriangle(c, a, b))
                answer = "yes";

            System.out.println("Scenario #" + i + ":");
            System.out.println(answer);
            System.out.println();
        }
    }

    private static boolean isRightAngledTriangle(int a, int b, int c) {
        return a * a + b * b == c * c;
    }
}