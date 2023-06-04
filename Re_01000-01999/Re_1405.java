import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static double check; // 결과
    static double[] prob; // 각 방향의 확률
    static boolean[][] visited;
    static int[] moveX = { 0, 0, 1, -1 }; // 남, 북 이동 방향
    static int[] moveY = { 1, -1, 0, 0 }; // 동, 서 이동 방향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        check = 0.0;
        prob = new double[4];
        visited = new boolean[n*2+1][n*2+1];

        for (int i = 0; i < 4; i++) {
            prob[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        visited[n][n] = true;
        solve(0, n, n, 1.0);

        bw.write(check + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void solve(int depth, int x, int y, double percentage) {
        if (depth == n) { // n 만큼 이동했다면 실행
            check += percentage; // 현재 이동한 순서에 대한 확률
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + moveX[i]; // 남, 북 이동에 대한 방향
            int ny = y + moveY[i]; // 동, 서 이동에 대한 방향

            if (visited[nx][ny] || prob[i] == 0) continue; // 한 번 지나간 곳이 아니며, 확률이 0이 아닌 경우
            visited[nx][ny] = true; // 지나간 방향으로 간주
            solve(depth + 1, nx, ny, percentage * prob[i]); // 현재 위치한 depth + 1, 좌표, 확률
            visited[nx][ny] = false; // 경우의 수를 위해 지나가지 않음으로 간주
        }
    }
}