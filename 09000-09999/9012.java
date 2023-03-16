import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        List<String> list;
        String parenthesisStr;
        int listLast;

        for (int i = 0; i < t; i++) {
            list = new ArrayList<>();
            parenthesisStr = br.readLine();
            for (String ch : parenthesisStr.split("")) {
                listLast = list.size() - 1;
                if (listLast == -1) {
                    list.add(ch);
                    continue;
                }

                if (ch.equals(")") && list.get(listLast).equals("(")) list.remove(listLast);
                else list.add(ch);
            }
            if (list.size() > 0) bw.write("NO" + "\n");
            else bw.write("YES" + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}