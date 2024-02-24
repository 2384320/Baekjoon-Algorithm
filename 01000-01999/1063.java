import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] kingCoordinate = getCoordinate(st.nextToken());
        int[] pawnCoordinate = getCoordinate(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            int idx = getIdx(br.readLine());

            int nx = kingCoordinate[0] + dx[idx];
            int ny = kingCoordinate[1] + dy[idx];
            if (nx == pawnCoordinate[0] && ny == pawnCoordinate[1]) {
                int nnx = pawnCoordinate[0] + dx[idx];
                int nny = pawnCoordinate[1] + dy[idx];

                if (checkRange(nnx, nny)) {
                    pawnCoordinate[0] = nnx;
                    pawnCoordinate[1] = nny;
                    kingCoordinate[0] = nx;
                    kingCoordinate[1] = ny;
                }
            } else {
                if (checkRange(nx, ny)) {
                    kingCoordinate[0] = nx;
                    kingCoordinate[1] = ny;
                }
            }
        }

        System.out.println(getCurrentLocation(kingCoordinate[0], kingCoordinate[1]));
        System.out.println(getCurrentLocation(pawnCoordinate[0], pawnCoordinate[1]));
        br.close();
    }

    private static int[] getCoordinate(String str) {
        return new int[] {8 - (str.charAt(1) - '0'), (str.charAt(0)) - 'A'};
    }

    private static int getIdx(String str) {
        int idx = 0;
        switch (str) {
            case "RT": idx = 1; break;
            case "R": idx = 2; break;
            case "RB": idx = 3; break;
            case "B": idx = 4; break;
            case "LB": idx = 5; break;
            case "L": idx = 6; break;
            case "LT": idx = 7; break;
        }
        return idx;
    }

    private static boolean checkRange(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    private static String getCurrentLocation(int x, int y) {
        return String.valueOf((char)(y + 'A')) + (8 - x);
    }
}