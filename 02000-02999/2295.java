import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] plusU;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] u = new int[n];
        plusU = new int[(n * (n + 1)) / 2];

        for (int i = 0; i < n; i++) {
            u[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(u);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                plusU[idx++] = u[i] + u[j];
            }
        }
        Arrays.sort(plusU);

        boolean flag = false;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (binarySearch(u[i] - u[j])) {
                    System.out.println(u[i]);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        br.close();
    }

    private static boolean binarySearch(int value) {
        int left = 0;
        int right = plusU.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (plusU[mid] > value)
                right = mid - 1;
            else if (plusU[mid] < value)
                left = mid + 1;
            else
                return true;
        }
        return false;
    }
}