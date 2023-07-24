import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int answer;
    private static int[] moveX = {0, 0, 1, -1};
    private static int[] moveY = {1, -1, 0, 0};
    private static boolean[] alphabet;
    private static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        answer = 0;
        alphabet = new boolean[26];
        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        dfs(0, 0, 0);

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int depth, int x, int y) {
        int a = arr[x][y] - 'A';
        if (alphabet[a]) {
            answer = Math.max(depth, answer);
            return;
        }
        
        alphabet[a] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + moveX[i];
            int ny = y + moveY[i];
            if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length) continue;
            dfs(depth + 1, nx, ny);
        }
        alphabet[a] = false;
    }

}