import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")){
                    tm.put(num, tm.getOrDefault(num, 0) + 1);
                }
                else if (command.equals("D") && !tm.isEmpty()) {
                    int key;
                    if (num == 1) key = tm.lastKey();
                    else key = tm.firstKey();

                    if (tm.get(key) == 1) tm.remove(key);
                    else tm.put(key, tm.get(key) - 1);
                }
            }

            if (tm.isEmpty()) bw.write("EMPTY\n");
            else bw.write(tm.lastKey() + " " + tm.firstKey() + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}