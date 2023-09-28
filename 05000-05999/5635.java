import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String maxName = "";
        String minName = "";
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            int sum = year * 365 + (month - 1) * 31 + day;
            if (sum > max) {
                max = sum;
                maxName = name;
            }

            if (sum < min) {
                min = sum;
                minName = name;
            }
        }
        System.out.println(maxName);
        System.out.println(minName);
        br.close();
    }
}