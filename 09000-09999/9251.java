import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length()+1][str2.length()+1];
        dp[0][0] = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        bw.write(dp[str1.length()][str2.length()] + "");
        bw.flush();
        br.close();
        bw.close();
    }
}

/* 반대로
import java.io.*;

public class Main {
    private static String str1, str2;
    private static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str1 = br.readLine();
        str2 = br.readLine();

        dp = new Integer[str1.length()][str2.length()];

        bw.write(LCS(str1.length() - 1, str2.length() - 1) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int LCS(int x, int y) {
        if (x == -1 || y == -1) return 0;

        if (dp[x][y] == null) {
            if (str1.charAt(x) == str2.charAt(y)) dp[x][y] = LCS(x - 1, y - 1) + 1;
            else dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
        }
        return dp[x][y];
    }
}
*/