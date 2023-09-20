import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int count = 0;
        int answer = 0;
        for (int i = 1; i < m - 1; i++) {
            if (arr[i - 1] == 'I' && arr[i] == 'O' && arr[i + 1] == 'I') {
                count++;

                if (count == n) {
                    count--;
                    answer++;
                }
                i++;
            } else
                count = 0;
        }
        System.out.println(answer);
        br.close();
    }
}