import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;

        long[] dist = new long[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        long[] city = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city.length; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        long min = city[0];
        answer = min * dist[0];
        for (int i = 2; i < n; i++) {
            min = Math.min(min, city[i-1]);
            answer += min * dist[i-1];
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}