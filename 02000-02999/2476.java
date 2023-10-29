import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int money = 0;

            if (arr[0] == arr[2])
                money = 10000 + arr[0] * 1000;
            else if (arr[0] == arr[1] || arr[1] == arr[2])
                money = 1000 + arr[1] * 100;
            else
                money = arr[2] * 100;

            answer = Math.max(answer, money);
        }
        System.out.println(answer);
        br.close();
    }
}