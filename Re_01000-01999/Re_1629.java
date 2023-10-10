import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        System.out.println(pow(a, b, c));
        br.close();
    }

    private static long pow(long a, long b, long c) {
        if (b == 0)
            return 1;

        long returnValue = pow(a, b/2, c) % c;

        if (b % 2 == 0) return (returnValue * returnValue) % c;
        return ((returnValue * returnValue) % c * (a % c)) % c;
    }
}