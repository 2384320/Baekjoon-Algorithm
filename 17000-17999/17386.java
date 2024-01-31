import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[2][4];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        if (getCCW(arr[0][0], arr[0][1], arr[0][2], arr[0][3], arr[1][0], arr[1][1])
                * getCCW(arr[0][0], arr[0][1], arr[0][2], arr[0][3], arr[1][2], arr[1][3]) < 0
                && getCCW(arr[1][0], arr[1][1], arr[1][2], arr[1][3], arr[0][0], arr[0][1])
                * getCCW(arr[1][0], arr[1][1], arr[1][2], arr[1][3], arr[0][2], arr[0][3]) < 0)
            answer = 1;

        System.out.println(answer);
        br.close();
    }

    private static int getCCW(long x1, long y1, long x2, long y2, long x3, long y3) {
        return (x1 * y2 + x2 * y3 + x3 * y1) - (x1 * y3 + x2 * y1 + x3 * y2) < 0 ? 1 : -1;
    }
}