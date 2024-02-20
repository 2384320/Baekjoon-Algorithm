import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final int ALPHABET_LENGTH = 26;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alphabet = new int[ALPHABET_LENGTH];
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            int length = words[i].length();
            int temp = (int) Math.pow(10, length - 1);
            for (int j = 0; j < length; j++) {
                alphabet[(int) words[i].charAt(j) - 'A'] += temp;
                temp /= 10;
            }
        }
        Arrays.sort(alphabet);

        int idx = 9;
        int answer = 0;
        for (int i = ALPHABET_LENGTH - 1; i >= 0; i--) {
            if (alphabet[i] == 0)
                break;
            answer += alphabet[i] * idx;
            idx--;
        }
        System.out.println(answer);
        br.close();
    }
}