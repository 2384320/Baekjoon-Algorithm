import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[][] arr = new int[n + 1][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int sliver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            arr[number][0] = gold;
            arr[number][1] = sliver;
            arr[number][2] = bronze;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (arr[i][0] == arr[j][0]) {
                    if (arr[i][1] == arr[j][1]) {
                        if (arr[i][2] > arr[j][2])
                            arr[j][3]++;
                        else if (arr[i][2] < arr[j][2])
                            arr[i][3]++;
                    } else if (arr[i][1] > arr[j][1]) {
                        arr[j][3]++;
                    } else
                        arr[i][3]++;
                } else if (arr[i][0] > arr[j][0]) {
                    arr[j][3]++;
                } else
                    arr[i][3]++;
            }
        }

        System.out.println(arr[k][3] + 1);
        br.close();
    }
}