import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0, sum = 0;
        int n = Integer.parseInt(br.readLine());
        String[] a = new String[n];

        for (int i = 0; i < n; i++) {
            a[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            char[] arr = a[i].toCharArray();

            count = 0; sum = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 'O') {
                    count++;
                    sum += count;
                } else count = 0;
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}