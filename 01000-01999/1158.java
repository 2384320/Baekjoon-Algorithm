import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        bw.write("<");
        while (n > 1) {
            count = (count + (k - 1)) % n;
            bw.write(list.remove(count) + ", ");
            n--;
        }
        bw.write(list.remove() + ">");

        bw.flush();
        br.close();
        bw.close();
    }
}