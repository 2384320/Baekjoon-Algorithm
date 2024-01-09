import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());
        int[] money = {500, 100, 50, 10, 5, 1};

        int answer = 0;
        for (int m : money) {
            answer += n / m;
            n %= m;
        }

        System.out.println(answer);
        br.close();
    }
}