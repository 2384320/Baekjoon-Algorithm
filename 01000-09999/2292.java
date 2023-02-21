import javax.lang.model.type.ArrayType;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean check = true;
        int count = 1, bee = 1;

        if (n == 1) check = false;

        while (check) {
            bee += 6*count;
            count++;
            if (bee >= n) break;
        }
        bw.write(count+"");

        bw.flush();
        br.close();
        bw.close();
    }

}