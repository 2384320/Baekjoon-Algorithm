import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[4];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        boolean flag = false;
        int mode_max = 0;
        int mode = 10000;

        for (int i = 0; i < n; i++) {
            int jump = 0;
            int count = 1;
            int i_value = arr[i];

            for (int j = i + 1; j < n; j++){
                if (i_value != arr[j]) break;
                count++;
                jump++;
            }

            if (count > mode_max) {
                mode_max = count;
                mode = i_value;
                flag = true;
            } else if (count == mode_max && flag) {
                mode = i_value;
                flag = false;
            }
            i += jump;
        }

        result[0] = (int)Math.round(sum / n);
        result[1] = arr[n/2];
        result[2] = mode;
        result[3] = arr[n-1] - arr[0];

        for (int r : result) {
            bw.write(r + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}