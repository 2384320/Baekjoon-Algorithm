import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static List<String> list = new ArrayList<>();
    static String[] arr;
    static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        arr = new String[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }

        backtracking(0, "");
        Collections.sort(list);

        bw.write(list.get(list.size()-1) + "\n" + list.get(0));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void backtracking(int depth, String num) {
        if (depth == k+1) {
            list.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;
            if (depth == 0 || possibility(num.charAt(depth - 1), (char)(i+'0'), arr[depth-1])) {
                visited[i] = true;
                backtracking(depth + 1, num + i);
                visited[i] = false;
            }
        }
    }
    private static boolean possibility(char num1, char num2, String compare) {
        if (compare.equals(">") && num1 < num2) return false;
        if (compare.equals("<") && num1 > num2) return false;
        return true;
    }
}