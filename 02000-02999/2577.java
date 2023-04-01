import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = null;
        int num = 1;
        int[] arr = new int[10];

        while ((str = br.readLine()) != null) {
            num *= Integer.parseInt(str);
        }

        str = Integer.toString(num);
        for (int i = 0; i < 10; i++) {
            bw.write(str.length() - str.replaceAll(Integer.toString(i), "").length() + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}