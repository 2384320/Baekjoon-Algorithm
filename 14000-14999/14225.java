import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.StringTokenizer;  
  
public class Main {  
    private static final int MAX_LENGTH = 100000 * 20 + 1;  
    private static int n;  
    private static int[] arr;  
    private static boolean[] visited;  
  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        n = Integer.parseInt(br.readLine());  
        arr = new int[n];  
        visited = new boolean[MAX_LENGTH];  
  
        StringTokenizer st = new StringTokenizer(br.readLine());  
        for (int i = 0; i < n; i++) {  
            arr[i] = Integer.parseInt(st.nextToken());  
        }  
        dfs(0, 0);  
  
        for (int i = 1; i < MAX_LENGTH; i++) {  
            if (!visited[i]) {  
                System.out.println(i);  
                break;            }  
        }  
        br.close();  
    }  
  
    private static void dfs(int depth, int sum) {  
        if (depth == n) {  
            visited[sum] = true;  
            return;        }  
  
        dfs(depth + 1, sum + arr[depth]);  
        dfs(depth + 1, sum);  
    }  
}