import javax.lang.model.type.ArrayType;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = 1;
        boolean check = true;

        if (b >= c) {
            check = false;
            n = -1;
        } else n = a / (c - b) + 1;

        bw.write(n+"");
        bw.flush();
        br.close();
        bw.close();
    }

}