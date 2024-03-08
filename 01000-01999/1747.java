import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (!(palindrome(n) && decimal(n))) {
            n++;
        }
        System.out.println(n);
        br.close();
    }

    private static boolean palindrome(int n) {
        char[] num = (String.valueOf(n)).toCharArray();

        for (int i = 0; i < num.length / 2; i++) {
            if (num[i] != num[num.length - 1 - i])
                return false;
        }
        return true;
    }

    private static boolean decimal(int n) {
        if ((n != 2 && n % 2 == 0) || n == 1)
            return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}