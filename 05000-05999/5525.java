import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int answer = 0;
        
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            if (s[i-1] == 'I' && s[i] == 'O' && s[i+1] == 'I') {
                count++;
                
                if (count == n) {
                    count--;
                    answer++;
                }
                i++;
            } else count = 0;
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}