import java.io.*;
import java.util.*;

import static java.lang.Float.NaN;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());
        String command, addStr;

        Stack<String> leftSt = new Stack<>();
        Stack<String> rightSt = new Stack<>();

        String[] arr = str.split("");
        for (String s: arr) {
            leftSt.push(s);
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            if (command.equals("L") && !leftSt.isEmpty()) rightSt.push(leftSt.pop());
            else if (command.equals("D") && !rightSt.isEmpty()) leftSt.push(rightSt.pop());
            else if (command.equals("B") && !leftSt.isEmpty()) leftSt.pop();
            else if (command.equals("P")) {
                addStr = st.nextToken();
                leftSt.push(addStr);
            }
        }
        while (!leftSt.isEmpty()) { rightSt.push(leftSt.pop()); }
        while (!rightSt.isEmpty()) { bw.write(rightSt.pop()); }
        bw.flush();
        br.close();
        bw.close();
    }
}