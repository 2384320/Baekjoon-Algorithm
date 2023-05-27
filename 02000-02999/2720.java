import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int c = Integer.parseInt(br.readLine());
            int quarter = 0;
            int dime = 0;
            int nickel = 0;
            int penny = 0;

            if (c / 25 > 0) {
                quarter = c / 25;
                c %= 25;
            }
            if (c / 10 > 0) {
                dime = c / 10;
                c %= 10;
            }
            if (c / 5 > 0) {
                nickel = c / 5;
                c %= 5;
            }
            penny = c;

            bw.write(quarter + " " + dime + " " + nickel + " " + penny + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}