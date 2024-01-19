import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String word = br.readLine();
        int strLength = str.length();
        int wordLength = word.length();
        int answer = 0;
        boolean[] isDuplicated = new boolean[strLength];

        for (int i = 0; i < strLength - wordLength + 1; i++) {
            if (str.substring(i, i + wordLength).equals(word) && !isDuplicated[i]) {
                answer++;
                for (int j = i; j < i + wordLength; j++) {
                    isDuplicated[j] = true;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}