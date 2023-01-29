import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        if (n == 4 || n == 7) count = -1;
        else if (n % 5 == 1 || n % 5 == 3) count = n / 5 + 1;
        else if (n % 5 == 2 || n % 5 == 4) count = n / 5 + 2;
        else count = n / 5;

        bw.write(count+"");
        bw.flush();
        br.close();
        bw.close();
    }
}