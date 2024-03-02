import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, List<String>> groupMember = new HashMap<>();
        HashMap<String, String> memberGroup = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String group = br.readLine();
            int k = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();

            for (int j = 0; j < k; j++) {
                String member = br.readLine();
                list.add(member);
                memberGroup.put(member, group);
            }
            Collections.sort(list);
            groupMember.put(group, list);
        }

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 0) {
                for (String answer : groupMember.get(question)) {
                    System.out.println(answer);
                }
            } else
                System.out.println(memberGroup.get(question));
        }
        br.close();
    }
}