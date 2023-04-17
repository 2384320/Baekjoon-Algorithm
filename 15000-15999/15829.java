import java.io.*;

public class Main {
    static final long mod = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(br.readLine());
        char[] chArr = br.readLine().toCharArray();
        long answer = 0;
        long pow = 1;
        for (int i = 0; i < l; i++) {
            long num = chArr[i] - 'a' + 1;
            answer += num * pow % mod;
            pow = pow * 31 % mod;
        }

        bw.write(answer % mod + "");
        bw.flush();
        br.close();
        bw.close();
    }
}