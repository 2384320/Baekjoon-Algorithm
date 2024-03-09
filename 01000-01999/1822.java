import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            hm.put(Integer.parseInt(st.nextToken()), 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (hm.containsKey(num))
                hm.put(num, 0);
        }

        for (int num : hm.keySet()) {
            if (hm.get(num) == 1)
                answer.add(num);
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (int num : answer) {
            System.out.print(num + " ");
        }
        br.close();
    }
}