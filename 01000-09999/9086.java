import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        String str;
        for (int i = 0; i < t; i++) {
            str = br.readLine();
            bw.write(str.charAt(0) + "" + str.charAt(str.length()-1) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}