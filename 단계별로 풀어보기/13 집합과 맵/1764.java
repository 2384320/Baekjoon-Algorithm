import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (set.contains(str)) list.add(str);
        }
        bw.write(list.size() + "\n");
        Collections.sort(list);
        
        for (String str: list) {
            bw.write(str + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}