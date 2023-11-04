import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                alpha[str.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < length; i++) {
                if (alpha[str.charAt(i) - 'a'] < k) continue;

                int count = 1;
                for (int j = i + 1; j < length; j++) {
                    if (str.charAt(i) == str.charAt(j))
                        count++;

                    if (count == k) {
                        min = Math.min(min, j - i + 1);
                        max = Math.max(max, j - i + 1);
                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE)
                System.out.println("-1");
            else
                System.out.println(min + " " + max);
        }
        br.close();
    }
}