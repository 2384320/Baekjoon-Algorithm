import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] isFriend = new boolean[n + 1];
        List<Integer>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        List<Integer> friends = new ArrayList<>();
        for (int f : list[1]) {
            friends.add(f);
            isFriend[f] = true;
        }

        for (int f : friends) {
            for (int ff : list[f]) {
                isFriend[ff] = true;
            }
        }

        int answer = 0;
        for (boolean is : isFriend) {
            if (is)
                answer++;
        }
        System.out.println(answer == 0 ? 0 : answer - 1);
        br.close();
    }
}