import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        int[] number = new int[9];

        for (String num : arr) {
            if (num.equals("6") || num.equals("9"))
                number[6]++;
            else
                number[Integer.parseInt(num)]++;
        }

        if (number[6] % 2 != 0)
            number[6] = number[6] / 2 + 1;
        else
            number[6] /= 2;

        int max = 0;
        for (int i = 0; i < 9; i++) {
            if (number[i] > max)
                max = number[i];
        }

        System.out.println(max);
        br.close();
    }
}