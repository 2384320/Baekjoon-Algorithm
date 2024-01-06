import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = ("0" + br.readLine()).toCharArray();
        int countZero = 0;
        int countOne = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                if (arr[i] == '0')
                    countZero++;
                else
                    countOne++;
            }
        }

        System.out.println(Math.max(countZero, countOne));
        br.close();
    }
}