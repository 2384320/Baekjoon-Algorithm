import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, answer, sum1, sum2;
    static int[][] team;
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        answer = 100;
        team = new int[n][n];
        arr = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
    
    public static void dfs(int depth, int idx) {
        if (depth == n/2) {
            sum1 = 0;
            sum2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (arr[i] && arr[j]) sum1 += team[i][j];
                    else if (!arr[i] && !arr[j]) sum2 += team[i][j];
                }
            }
            answer = Math.min(answer, Math.abs(sum2 - sum1));
        }

        for (int i = idx; i < n; i++) {
            arr[i] = true;
            dfs(depth + 1, i + 1);
            arr[i] = false;
        }
    }
}