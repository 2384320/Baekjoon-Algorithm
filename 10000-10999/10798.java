import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = new String[15];
        for (int i = 0; i < 5; i++) {
            String c = br.readLine();
            for (int j = 0; j < c.length(); j++) {
                if (arr[j] == null) arr[j] = "";
                arr[j] += String.valueOf(c.charAt(j));
            }
        }

        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) break;
            answer += arr[i];
        }
        bw.write(answer);
        bw.flush();
        br.close();
        bw.close();
    }
}