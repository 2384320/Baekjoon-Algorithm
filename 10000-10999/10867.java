import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hs.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> list = new ArrayList<>(hs);
        Collections.sort(list);

        for (int num : list) {
            bw.write(num + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}