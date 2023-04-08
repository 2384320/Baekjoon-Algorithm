import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0, t = n;
        while (t-- > 0) {
            for (int i = 0; i < k; i++) {
                count++;
                if (count > n) count -= n;
                if (!check[count]) continue;
                i--;
            }
            queue.add(count);
            check[count] = true;
        }
        bw.write("<" + queue.poll());
        for (int i = 0; i < n - 1; i++) {
            bw.write(", " + queue.poll());
        }
        bw.write(">");

        bw.flush();
        br.close();
        bw.close();
    }
}