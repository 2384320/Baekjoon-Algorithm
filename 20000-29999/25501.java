import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            bw.write(isPalindrome(br.readLine()) + "\n");
            count = 0;
        }

        bw.flush();
        br.close();
        bw.close();
    }
    public static String recursion(String s, int l, int r) {
        count++;
        if(l >= r) return 1 + " " + count;
        else if(s.charAt(l) != s.charAt(r)) return 0 + " " + count;
        else return recursion(s, l+1, r-1);
    }
    public static String isPalindrome(String s) {
        return recursion(s, 0, s.length()-1);
    }
}