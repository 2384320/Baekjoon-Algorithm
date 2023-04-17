import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        while (k-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) stack.pop();
            else stack.push(num);
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sum += stack.peek();
            stack.pop();
        }

        bw.write(sum + "");
        bw.flush();
        br.close();
        bw.close();
    }
}