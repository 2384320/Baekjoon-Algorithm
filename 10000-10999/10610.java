import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int sum = 0;
        int length = arr.length;
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);

        for (int i = length - 1; i >= 0; i--) {
            int num = arr[i] - '0';
            sum += num;
            sb.append(num);
        }

        if (arr[0] != '0' || sum % 3 != 0)
            System.out.println(-1);
        else
            System.out.println(sb);

        br.close();
    }
}