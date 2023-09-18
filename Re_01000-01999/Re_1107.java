import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = Math.abs(n - 100);
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        if (m != 0)
            st = new StringTokenizer(br.readLine());

        boolean[] notAvailable = new boolean[10];
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            notAvailable[num] = true;
        }

        for (int i = 0; i <= 999999; i++) {
            String channel = String.valueOf(i);
            int length = channel.length();
            boolean check = false;

            for (int j = 0; j < length; j++) {
                if (notAvailable[channel.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }

            if (!check)
                min = Math.min(min, Math.abs(n - i) + length);
        }
        System.out.println(min);
        br.close();
    }
}