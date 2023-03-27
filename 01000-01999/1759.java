import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int l, c, countVowel = 0, countConsonant = 0;
    static char[] letter;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        letter = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            letter[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(letter);

        dfs(0, "");
    }

    public static void dfs(int idx, String str) {
        if (str.length() == l) {
            countVowel = str.replaceAll("[^aeiou]", "").length();
            countConsonant = str.replaceAll("[aeiou]", "").length();
            if (countVowel >= 1 && countConsonant >= 2) System.out.println(str);
            return;
        }

        if (idx >= c) return;

        dfs(idx + 1, str + letter[idx]);
        dfs(idx + 1,  str);
    }
}