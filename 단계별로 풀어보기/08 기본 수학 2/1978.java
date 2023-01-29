import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int prime = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int count = 0;

            for (int j = 1; j <= num; j++) {
                if (num % j == 0) count++;
            }
            if (count == 2) prime++;
        }

        bw.write(prime+"");
        bw.flush();
        br.close();
        bw.close();
    }
}