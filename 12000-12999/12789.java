import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == count) {
                count++;
                while (!stack.isEmpty()) {
                    if (stack.peek() == count) {
                        stack.pop();
                        count++;
                    } else break;
                }
            } else {
                stack.push(num);
            }
        }

        if (n < count)
            System.out.println("Nice");
        else
            System.out.println("Sad");

        br.close();
    }
}