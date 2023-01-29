import javax.lang.model.type.ArrayType;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int cut_line = 1, count = 1, index = 1, numerator = 1, denominator = 1;
        boolean check = true;

        while (check) {
            if (cut_line >= x && (cut_line - count) <= x) {

                index = count - (cut_line - x) - 1;
                if (count % 2 == 0) {
                    numerator = 1 + index;
                    denominator = count - index;
                }
                else {
                    numerator = count - index;
                    denominator = 1 + index;
                }
                break;
            } else {
                count++;
                cut_line += count;
            }
        }
        bw.write(numerator+"/"+denominator+"");

        bw.flush();
        br.close();
        bw.close();
    }

}