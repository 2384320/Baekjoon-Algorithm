import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] button = new boolean[10];
        StringTokenizer st = null;
        
        if (m != 0) st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            button[num] = true;
        }

        int min = Math.abs(n - 100);
        for (int i = 0; i <= 999999; i++) {
            String channel = String.valueOf(i);
            int length = channel.length();
            boolean isBroken = false;

            for (int j = 0; j < length; j++) {
                if (button[channel.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }

            if (!isBroken) min = Math.min(min, Math.abs(n - i) + length);
        }
        bw.write(min + "");
        bw.flush();
        br.close();
        bw.close();
    }
}