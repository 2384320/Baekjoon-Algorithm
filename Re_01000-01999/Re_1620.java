import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> hm_idx = new HashMap<>();
        HashMap<String, Integer> hm_str = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String pokemon = br.readLine();
            hm_idx.put(i, pokemon);
            hm_str.put(pokemon, i);
        }

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            if (Character.isDigit(question.charAt(0))) bw.write(hm_idx.get(Integer.parseInt(question)) + "\n");
            else bw.write(hm_str.get(question) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}