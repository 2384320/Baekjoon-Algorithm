import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs(0, "");
    }

    public static void dfs(int depth, String str) {
        if (depth == n) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (check(str+i)) dfs(depth+1, str+i);
        }
    }

    public static boolean check(String str) {
        int size = str.length();
        for (int i = 1; i <= size/2; i++) {
            String s1 = str.substring(size - 2*i, size - i);
            String s2 = str.substring(size - i);
            if (s1.equals(s2)) return false;
        }
        return true;
    }
}