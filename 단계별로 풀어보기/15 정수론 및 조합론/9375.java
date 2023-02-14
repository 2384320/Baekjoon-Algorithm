import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n, answer;
        HashMap<String, Integer> hm;
        StringTokenizer st;
        String kind, clothes = "";

        for (int i = 0; i < t; i++) {
            hm = new HashMap<>();
            n = Integer.parseInt(br.readLine());
            answer = 1;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                clothes = st.nextToken();
                kind = st.nextToken();
                // 같은 이름을 가진 의상은 존재하지 않으므로 의상 종류만 카운팅
                if (hm.containsKey(kind)) hm.put(kind, hm.get(kind) + 1);
                else hm.put(kind, 1);
                // 의상 종류가 하나임을 대비하여 키 값을 가져오기 위한 버리는 변수 활용
                clothes = kind;
            }

            // val에 + 1을 하는 이유는 아무것도 입지 않은 경우의 수도 생각해야 하기 때문임.
            for (int val: hm.values()) {
                answer *= (val + 1);
            }
            // 아무 종류의 옷도 착용하지 않아 알몸 상태인 경우는 빼줘야 함.
            bw.write(answer - 1 + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}