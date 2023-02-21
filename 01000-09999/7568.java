import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] check = new int[n];
        Arrays.fill(check, 1);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) check[j]++;
                else if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) check[i]++;
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(check[i] + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}