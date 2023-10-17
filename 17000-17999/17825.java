import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int answer;
    private static int[] board = {
            0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0,
            10, 13, 16, 19, 25, 30, 35, 40, 0,
            20, 22, 24, 25, 30, 35, 40, 0,
            30, 28, 27, 26, 25, 30, 35, 40, 0
    };
    private static int[] dice, horse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = 0;
        dice = new int[10];
        horse = new int[10];
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(answer);
        br.close();
    }

    private static void dfs(int depth) {
        if (depth == 10) {
            moveHorse();
            return;
        }

        for (int j = 0; j < 4; j++) {
            horse[depth] = j;
            dfs(depth + 1);
        }
    }

    private static void moveHorse() {
        boolean[] visited = new boolean[board.length];
        int count = 0;
        int[] spot = new int[4];

        for (int i = 0; i < 10; i++) {
            int d = dice[i];
            int h = horse[i];
            if (isFinish(spot[h])) return;

            int next = nextSpot(spot[h], d);
            if (isFinish(next)) {
                setVisited(visited, spot[h], false);
                spot[h] = next;
                continue;
            }

            if (visited[next]) return;
            setVisited(visited, spot[h], false);
            setVisited(visited, next, true);

            spot[h] = next;
            count += board[spot[h]];
        }
        answer = Math.max(answer, count);
    }

    private static boolean isFinish(int idx) {
        return idx == 21 || idx == 30 || idx == 38 || idx == 47;
    }

    private static int nextSpot(int idx, int dice) {
        int next = idx + dice;

        if (idx < 21) {
            if (next >= 21)
                next = 21;
        } else if (idx < 30) {
            if (next >= 30)
                next = 30;
        } else if (idx < 38) {
            if (next >= 38)
                next = 38;
        } else if (idx < 47) {
            if (next >= 47)
                next = 47;
        }

        if (next == 5) return 22;
        if (next == 10) return 31;
        if (next == 15) return 39;
        return next;
    }

    private static void setVisited(boolean[] visited, int idx, boolean check) {
        if (idx == 20 || idx == 29 || idx == 37 || idx == 46) {
            visited[20] = check;
            visited[29] = check;
            visited[37] = check;
            visited[46] = check;
        } else if (idx == 26 || idx == 34 || idx == 43) {
            visited[26] = check;
            visited[34] = check;
            visited[43] = check;
        } else if (idx == 27 || idx == 35 || idx == 44) {
            visited[27] = check;
            visited[35] = check;
            visited[44] = check;
        } else if (idx == 28 || idx == 36 || idx == 45) {
            visited[28] = check;
            visited[36] = check;
            visited[45] = check;
        } else
            visited[idx] = check;
    }
}