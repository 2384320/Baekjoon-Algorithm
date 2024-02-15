import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Egg {
        int s, w;

        Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }

    private static int n, max;
    private static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max = 0;
        eggs = new Egg[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(s, w);
        }

        backtracking(0, 0);
        System.out.println(max);
        br.close();
    }

    private static void backtracking(int idx, int count) {
        if (idx == n) {
            max = Math.max(max, count);
            return;
        }

        if (eggs[idx].s <= 0 || count == n - 1) {
            backtracking(idx + 1, count);
            return;
        }

        int nCount = count;
        for (int i = 0; i < n; i++) {
            if (i == idx) continue;
            if (eggs[i].s <= 0) continue;

            hit(idx, i);

            if (eggs[idx].s <= 0)
                count++;
            if (eggs[i].s <= 0)
                count++;

            backtracking(idx + 1, count);
            recover(idx, i);
            count = nCount;
        }
    }

    private static void hit(int hand, int target) {
        eggs[hand].s -= eggs[target].w;
        eggs[target].s -= eggs[hand].w;
    }

    private static void recover(int hand, int target) {
        eggs[hand].s += eggs[target].w;
        eggs[target].s += eggs[hand].w;
    }
}