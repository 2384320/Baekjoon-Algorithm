import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str;

        for (int i = 0; i < n*2-1; i++) {
            if (i > n-1) str = " ".repeat(Math.abs(n-i-1)) + "*".repeat(4*n-2*i-3);
            else str = " ".repeat(Math.abs(n-i-1)) + "*".repeat(2*i+1);
            bw.write(str + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}