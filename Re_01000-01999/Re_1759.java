import java.io.*;
import java.util.*;

public class Main {
    static int l, c;
    static char[] arr;
    static boolean[] visited;
    static List<Character> vowelList;
    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        visited = new boolean[c];
        vowelList = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        dfs(0, 0, "");
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int depth, int idx, String str) {
        if (depth == l && str.length() == l) {
            int consonant = 0;
            int vowel = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (vowelList.contains(ch)) vowel++;
                else consonant++;
            }
            if (vowel >= 1 && consonant >= 2) list.add(str);
            return;
        }

        for (int i = idx; i < c; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1, str + arr[i]);
                visited[i] = false;
            }
        }
    }
}