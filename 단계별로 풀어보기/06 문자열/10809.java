import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] s = br.readLine().toCharArray();
        String str = String.valueOf(s);

        for (int i = 0; i < 26; i++) {
            bw.write(str.indexOf((char)('a' + i)) + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}