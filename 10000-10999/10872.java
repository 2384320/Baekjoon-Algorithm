import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int fac = 1;

        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                fac *= i;
            }
        }
        
        bw.write(fac+"");
        bw.flush();
        br.close();
        bw.close();
    }
}