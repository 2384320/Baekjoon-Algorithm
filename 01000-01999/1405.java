import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[][] visited = new boolean[30][30]; // 지나갔던 곳 표시
    static double[] prob = new double[4]; // 각 방향의 확률
    static double check; // 결과
    static int[] r = { 0, 0, 1, -1 }; // 남, 북 이동 방향
    static int[] c = { 1, -1, 0, 0 }; // 동, 서 이동 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            prob[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        visited[15][15] = true;
        solve(15, 15, 1.0, 0);

        bw.write(check + "");
        bw.flush();
        br.close();
        bw.close();
    }
    public static void solve(int nr, int nc, double mul, int move) {
        if (move == n) { // n 만큼 이동했다면 실행
            check += mul; // 현재 이동한 순서에 대한 확률
            return;
        }

        for (int i = 0; i < 4; i++) {
            int mr = nr + r[i]; // 남, 북 이동에 대한 방향
            int mc = nc + c[i]; // 동, 서 이동에 대한 방향
            System.out.println(mr + " " + mc + " " + mul * prob[i]);
            if (!visited[mr][mc] && prob[i] > 0) { // 한 번 지나간 곳이 아니며, 확률이 0이 아닌 경우
                visited[mr][mc] = true; // 지나간 방향으로 간주
                solve(mr, mc, mul * prob[i], move + 1); // 현재 위치한 좌표, 확률, depth + 1
                visited[mr][mc] = false; // 경우의 수를 위해 지나가지 않음으로 간주
            }
        }
    }
}