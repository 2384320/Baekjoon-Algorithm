import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 1)
                sum++;
            else
                sum--;
        }

        if (sum > 0)
            System.out.println("Junhee is cute!");
        else
            System.out.println("Junhee is not cute!");
        br.close();
    }
}