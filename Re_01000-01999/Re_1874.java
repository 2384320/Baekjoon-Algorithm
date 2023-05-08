import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int pushCount = 0;
        Stack<Integer> stack = new Stack<>();

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num > pushCount) {
                for (int i = pushCount+1; i <= num; i++) {
                    stack.add(i);
                    sb.append("+").append("\n");
                }
                pushCount = num;
            } else if (stack.peek() != num) {
                System.out.println("NO");
                System.exit(0);
            }
            stack.pop();
            sb.append("-").append("\n");
        }

        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }
}