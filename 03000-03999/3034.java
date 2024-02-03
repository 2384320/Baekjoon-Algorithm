import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            int length = Integer.parseInt(br.readLine());

            if (w * w + h * h >= length * length)
                System.out.println("DA");
            else
                System.out.println("NE");
        }
        br.close();
    }
}