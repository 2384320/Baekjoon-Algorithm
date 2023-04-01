import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;

        while (st.hasMoreTokens()) {
            sum += (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
        }
        bw.write(sum % 10 + "");

        bw.flush();
        br.close();
        bw.close();
    }
}