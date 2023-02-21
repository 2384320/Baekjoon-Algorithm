import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), answer = 0;

        while (n >= 5) {
            answer += n / 5;
            n /= 5;
        }

        bw.write(answer + "");

        bw.flush();
        br.close();
        bw.close();
    }
}