import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String result = "", left, right;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        dfs(0, "");
    }

    public static void dfs(int depth, String resultStr) throws IOException {
        if (depth == n) {
            bw.write(resultStr + "");
            bw.flush();
            br.close();
            bw.close();
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (compare(resultStr + i)) dfs(depth + 1, resultStr + i);
        }
    }

    public static boolean compare(String str) {
        int length = str.length();
        for (int i = 1; i <= length / 2; i++) {
            right = str.substring(length - i);
            left = str.substring(length - 2 * i, length - i);
            if (left.equals(right)) return false;
        }
        return true;
    }
}