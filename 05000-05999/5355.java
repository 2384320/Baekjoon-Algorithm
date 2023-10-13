import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] arr = br.readLine().split(" ");
            float num = Float.parseFloat(arr[0]);

            for (int i = 1; i < arr.length; i++) {
                switch (arr[i]) {
                    case "@": num *= 3; break;
                    case "%": num += 5; break;
                    case "#": num -= 7; break;
                }
            }
            System.out.printf("%.2f\n", num);
        }
        br.close();
    }
}