import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String str = br.readLine();
            String answer = "YES";
            if (!origami(str))
                answer = "NO";
            System.out.println(answer);
        }
        br.close();
    }

    private static boolean origami(String str) {
        int length = str.length();
        if (length == 1) return true;

        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) == str.charAt(length - i - 1)) return false;
        }

        return origami(str.substring(0, length / 2))
                && origami(str.substring(length / 2 + 1));
    }
}