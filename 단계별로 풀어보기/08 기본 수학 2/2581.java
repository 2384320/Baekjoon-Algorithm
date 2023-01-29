import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0, min = n;

        x : for (int i = m; i <= n; i++) {
            if (i == 1) continue;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) continue x;
            }
            sum += i;
            if (i < min) min = i;
        }

        if (sum == 0) bw.write(-1+"");
        else bw.write(sum+"\n"+min);
        bw.flush();
        br.close();
        bw.close();
    }
}