import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String answer = "SK";
        if (n % 2 == 0)
            answer = "CY";
        System.out.println(answer);
        br.close();
    }
}