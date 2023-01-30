import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i <= str.length(); i++) {
            for (int j = 1; j+i <= str.length(); j++) {
                hs.add(str.substring(i, i+j));
            }
        }

        bw.write(hs.size() + "");
        bw.flush();
        br.close();
        bw.close();
    }
}