import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static int length1, length2;
    private static String str1, str2;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str1 = br.readLine();
        str2 = br.readLine();

        length1 = str1.length();
        length2 = str2.length();
        int length = LCS();

        StringBuilder sb = new StringBuilder();
        while (length1 > 0 && length2 > 0) {
            if (str1.charAt(length1 - 1) == str2.charAt(length2 - 1)) {
                sb.insert(0, str1.charAt(length1 - 1));
                length1--;
                length2--;
            } else if (dp[length1][length2] == dp[length1 - 1][length2])
                length1--;
            else if (dp[length1][length2] == dp[length1][length2 - 1])
                length2--;
        }

        bw.write(length + "\n" + sb);
        bw.flush();
        br.close();
        bw.close();
    }

    private static int LCS() {
        dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[length1][length2];
    }
}