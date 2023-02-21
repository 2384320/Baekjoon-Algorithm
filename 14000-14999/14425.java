import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr_n = new String[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr_n[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (String arr: arr_n) {
                if (arr.equals(str)) {
                    count++;
                    break;
                }
            }
        }

        bw.write(count+"");
        bw.flush();
        br.close();
        bw.close();
    }
}