import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long w = Integer.parseInt(st.nextToken());
        long s = Integer.parseInt(st.nextToken());
        long answer = 0;

        if (2 * w < s)
            answer = (x + y) * w;
        else if (2 * w > 2 * s) {
            if ((x + y) % 2 == 0)
                answer = Math.max(x, y) * s;
            else {
                answer = (Math.max(x, y) - 1) * s;
                answer += w;
            }
        } else {
            if (x == y)
                answer = s * x;
            else {
                answer = Math.min(x * s, y * s);
                answer += Math.abs(x - y) * w;
            }
        }

        System.out.println(answer);
        br.close();
    }
}