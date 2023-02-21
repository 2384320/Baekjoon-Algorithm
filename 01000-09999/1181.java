import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        //String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (!list.contains(str)) list.add(str);
            //arr[i] = st.nextToken();
        }
        String[] arr = list.toArray(new String[list.size()]);
        Arrays.sort(arr, (e1, e2) -> {
            if (e1.length() == e2.length()) return e1.compareTo(e2);
            else return e1.length() - e2.length();
        });

        for (String str : arr) {
            bw.write(str+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}