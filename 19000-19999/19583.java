import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = getTime(st.nextToken());
        int e = getTime(st.nextToken());
        int q = getTime(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>();
        while (true) {
            try {
                st = new StringTokenizer(br.readLine());
                int time = getTime(st.nextToken());
                String name = st.nextToken();

                if (time <= s) {
                    if (!hm.containsKey(name))
                        hm.put(name, 0);
                } else if (time >= e && time <= q) {
                    if (hm.containsKey(name))
                        hm.put(name, 1);
                }
            } catch (Exception exception) {
                break;
            }
        }

        int answer = 0;
        for (int num : hm.values()) {
            if (num == 1)
                answer++;
        }
        System.out.println(answer);
        br.close();
    }

    private static int getTime(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 100 + Integer.parseInt(time.substring(3, 5));
    }
}