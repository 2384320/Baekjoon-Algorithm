import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int r = h / 2;

        int answer = 0;
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int xx = Integer.parseInt(st.nextToken());
            int yy = Integer.parseInt(st.nextToken());

            if ((x <= xx && xx <= x + w && y <= yy && yy <= y + h)
                    || r * r >= Math.pow(x - xx, 2) + Math.pow(y + r - yy, 2)
                    || r * r >= Math.pow(x + w - xx, 2) + Math.pow(y + r - yy, 2))
                answer++;
        }
        System.out.println(answer);
        br.close();
    }
}