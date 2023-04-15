import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num, answer;
        while (!(num = br.readLine()).equals("0")) {
            answer = "yes";
            int size = num.length();
            for (int i = 0; i < size/2; i++) {
                if (!num.substring(i, i+1).equals(num.substring(size - i - 1, size -i))) {
                    answer = "no";
                    break;
                }
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}