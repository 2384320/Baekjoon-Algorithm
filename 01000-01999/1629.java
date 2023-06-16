import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        bw.write(pow(a, b, c) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static long pow(long a, long b, long c) {
        if (b == 0) return 1;

        long returnValue = pow(a, b/2, c) % c;

        if (b % 2 == 0) return (returnValue * returnValue) % c;
        return ((returnValue * returnValue) % c * (a % c)) % c;
    }
}