import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            boolean[] check = new boolean[26];
            boolean result = true;

            for (int j = 0; j < str.length(); j++) {
                if (check[str.charAt(j)-'a']) {
                    if (str.charAt(j) != str.charAt(j-1)) {
                        result = false;
                        break;
                    }
                } else {
                    check[str.charAt(j)-'a'] = true;
                }
            }
            if (result) count++;
        }
        bw.write(count+"");

        bw.flush();
        br.close();
        bw.close();
    }

}