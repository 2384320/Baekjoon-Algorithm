import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int r = Integer.parseInt(br.readLine()); // radius

        bw.write(r*r*Math.PI + "\n" + r*r*2);
        bw.flush();
        br.close();
        bw.close();
    }
}