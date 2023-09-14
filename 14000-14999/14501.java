import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Work> work = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            work.add(new Work(t, p));
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int r = work.get(i).requiredDay;
            if (i + r <= n)
                dp[i + r] = Math.max(dp[i + r], dp[i] + work.get(i).money);
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        bw.write(dp[n] + "");
        bw.flush();
        br.close();
        bw.close();
    }
}

class Work {
    int requiredDay, money;

    Work(int requiredDay, int money) {
        this.requiredDay = requiredDay;
        this.money = money;
    }
}