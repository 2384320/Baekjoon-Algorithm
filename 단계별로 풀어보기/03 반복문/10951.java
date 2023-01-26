import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int a, b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            st = new StringTokenizer(line);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bw.write((a+b)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}