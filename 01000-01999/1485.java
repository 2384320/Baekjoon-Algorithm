import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int[][] arr = new int[4][2];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            boolean flag = true;
            double[] length = new double[6];
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    length[count++] = getLength(arr[i][0], arr[i][1], arr[j][0], arr[j][1]);
                }
            }
            Arrays.sort(length);

            for (int i = 1; i < 4; i++) {
                if (length[0] != length[i]) {
                    flag = false;
                    break;
                }
            }

            if (length[4] != length[5])
                flag = false;

            if (flag)
                System.out.println(1);
            else
                System.out.println(0);
        }
        br.close();
    }

    private static double getLength(long x1, long y1, long x2, long y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}