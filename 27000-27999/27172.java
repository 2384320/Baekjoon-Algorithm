import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final int SIZE = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[SIZE];
        boolean[] card = new boolean[SIZE];
        int[] player = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            player[i] = Integer.parseInt(st.nextToken());
            card[player[i]] = true;
        }

        for (int i : player) {
            for (int j = i * 2; j < SIZE; j += i) {
                if (card[j]) {
                    num[i]++;
                    num[j]--;
                }
            }
        }

        for (int p : player) {
            bw.write(num[p] + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}