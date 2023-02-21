import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char n = br.readLine().charAt(0);
        bw.write((byte)n + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}