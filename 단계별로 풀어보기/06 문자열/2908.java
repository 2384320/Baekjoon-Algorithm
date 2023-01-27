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

        a = (a%10*100) + (a/10%10*10) + (a/100);
        b = (b%10*100) + (b/10%10*10) + (b/100);

        if (a > b) bw.write(a + "");
        else bw.write(b + "");

        bw.flush();
        br.close();
        bw.close();
    }
}