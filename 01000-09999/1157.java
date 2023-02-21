import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toUpperCase();
        int[] count = new int[26];
        int max = 0, both = 0, index = 0;

        for (int i = 0; i < str.length(); i++) {
            count[(int)(str.charAt(i))-'A'] += 1;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) max = count[i];
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                both++;
                index = i;
            }
        }

        if (both >= 2) bw.write("?" + "");
        else {
            bw.write((char)(index+'A') + "");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}