import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String boom = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int length = boom.length();

        for (char ch : str.toCharArray()) {
            stack.push(ch);

            if (stack.size() >= length) {
                boolean flag = true;
                for (int i = 0; i < length; i++) {
                    if (stack.get(stack.size() - length + i) != boom.charAt(i)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int i = 0; i < length; i++) {
                        stack.pop();
                    }
                }
            }
        }

        for (char ch : stack) {
            sb.append(ch);
        }
        if (sb.length() == 0) bw.write("FRULA");
        else bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}