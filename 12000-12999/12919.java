import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        System.out.println(makeS(s, t));
        br.close();
    }

    private static int makeS(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t))
                return 1;
            return 0;
        }

        int answer = 0;
        if (t.charAt(0) == 'B') {
            String substring = t.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            String string = sb.reverse().toString();
            answer += makeS(s, string);
        }

        if (t.charAt(t.length() - 1) == 'A')
            answer += makeS(s, t.substring(0, t.length() - 1));
        return answer > 0 ? 1 : 0;
    }

}