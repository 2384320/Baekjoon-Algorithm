import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] mbti = new String[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                mbti[i] = st.nextToken();
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        min = Math.min(min, getDistance(mbti[i], mbti[j], mbti[k]));
                        if (min == 0)
                            break;
                    }
                    if (min == 0)
                        break;
                }
                if (min == 0)
                    break;
            }

            System.out.println(min);
        }
        br.close();
    }

    private static int getDistance(String mbti1, String mbti2, String mbti3) {
        return distance(mbti1, mbti2) + distance(mbti2, mbti3) + distance(mbti1, mbti3);
    }

    private static int distance(String mbti1, String mbti2) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (mbti1.charAt(i) != mbti2.charAt(i))
                sum++;
        }
        return sum;
    }
}