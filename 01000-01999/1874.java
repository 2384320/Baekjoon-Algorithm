import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num, pushCount = 0, stackNum = 1;
        String answer = "";
        List<String> answerList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        x: for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            while (true) {
                if (pushCount < num) {
                    stack.push(stackNum++);
                    pushCount++;
                    answerList.add("+");
                }
                else {
                    if (stack.peek() == num) {
                        answerList.add("-");
                        stack.pop();
                        break;
                    } else {
                        answer = "NO";
                        break x;
                    }
                }
            }
        }

        if (answer.equals("NO")) bw.write("NO");
        else {
            for (int i = 0; i < answerList.size(); i++) {
                bw.write(answerList.get(i) + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}