import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static HashMap<String, String> hm;
    private static HashMap<String, Integer> size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int f = Integer.parseInt(br.readLine());
            hm = new HashMap<>();
            size = new HashMap<>();

            for (int i = 0; i < f; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();

                hm.put(friend1, hm.getOrDefault(friend1, friend1));
                size.put(friend1, size.getOrDefault(friend1, 1));

                hm.put(friend2, hm.getOrDefault(friend2, friend2));
                size.put(friend2, size.getOrDefault(friend2, 1));

                bw.write(union(friend1, friend2) + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int union(String friend1, String friend2) {
        friend1 = find(friend1);
        friend2 = find(friend2);

        if (!friend1.equals(friend2)) {
            hm.put(friend2, friend1);
            size.put(friend1, size.get(friend1) + size.get(friend2));
        }
        return size.get(friend1);
    }

    private static String find(String friend) {
        if (friend.equals(hm.get(friend))) return friend;
        hm.put(friend, find(hm.get(friend)));
        return hm.get(friend);
    }
}