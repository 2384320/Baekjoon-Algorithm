import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0, max = -4000, min = 4000, mode = 0, mode_max = 0;
        boolean check = false;
        int[] count = new int[8001];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) max = arr[i];
            if (min > arr[i]) min = arr[i];
            sum += arr[i];
            count[arr[i]+4000]++;
        }

        Arrays.sort(arr);

        for (int i = 0; i < count.length; i++) {
            if (count[i] > mode_max) {
                mode_max = count[i];
                mode = i - 4000;
                check = true;
            } else if (mode_max == count[i] && check) {
                mode = i - 4000;
                check = false;
            }
        }

        bw.write((Math.round((double)sum/n))+"\n"+arr[n/2]+"\n"+mode+"\n"+(max-min));

        bw.flush();
        br.close();
        bw.close();
    }
}