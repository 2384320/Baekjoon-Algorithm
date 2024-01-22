import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m, k;
    private static int[] judge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        judge = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            judge[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(binarySearch());
        br.close();
    }

    private static String binarySearch() {
        String answer = null;
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = (left + right) / 2;
            String j = setJudge(mid);
            if (j.charAt(0) == '-')
                right = mid - 1;
            else {
                left = mid + 1;
                answer = j;
            }
        }
        return answer;
    }

    private static String setJudge(int dist) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append("1");

        int lastIdx = judge[0];
        for (int i = 1; i < k; i++) {
            int idx = judge[i];
            if (idx - lastIdx < dist)
                sb.append("0");
            else {
                sb.append("1");
                lastIdx = idx;
                count++;
            }

            if (count == m) {
                sb.append("0".repeat(k - i - 1));
                break;
            }
        }
        return count == m ? sb.toString() : "-";
    }
}