import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;

        int num = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    num = Math.max(num, dp[i]);
                }
            }
        }

        System.out.println(num);
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == num) {
                num--;
                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        br.close();
    }
}