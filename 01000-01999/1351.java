import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static long q, p;
    private static HashMap<Long, Long> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());

        hm = new HashMap<>();
        hm.put(0L, 1L);

        System.out.println(getValue(n));
        br.close();
    }

    private static long getValue(long idx) {
        if (!hm.containsKey(idx))
            hm.put(idx, getValue(idx / p) + getValue(idx / q));
        return hm.get(idx);
    }
}