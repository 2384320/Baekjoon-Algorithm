import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = 1;
        int cut = 0;

        while (n < k)
            n *= 2;

        System.out.print(n + " ");

        while (k > 0) {
            if (k >= n)
                k -= n;
            else {
                n /= 2;
                cut++;
            }
        }

        System.out.println(cut);
        br.close();
    }
}