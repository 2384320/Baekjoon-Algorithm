import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }
        int length = min;

        for (int i = min; i <= max; i++) {
            int inventory = b;
            int digCount = dig(i, map);
            inventory += digCount;

            int insertCount = insert(i, map, inventory);
            if (insertCount == -1) continue;

            if (answer >= digCount * 2 + insertCount) {
                answer = digCount * 2 + insertCount;
                length = i;
            }

        }
        bw.write(answer + " " + length);
        bw.flush();
        br.close();
        bw.close();
    }

    public static int dig(int num, int[][] map) {
        int digCount = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (num >= map[i][j]) continue;
                digCount += map[i][j] - num;
            }
        }
        return digCount;
    }

    public static int insert(int num, int[][] map, int b) {
        int insertCount = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (num <= map[i][j]) continue;
                if (b < num - map[i][j]) return -1;
                insertCount += num - map[i][j];
                b -= num - map[i][j];
            }
        }
        return insertCount;
    }
}