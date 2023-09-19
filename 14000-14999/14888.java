import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.StringTokenizer;  
  
public class Main {  
    private static int n, max, min;  
    private static int[] arr, operator;  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        n = Integer.parseInt(br.readLine());  
        max = Integer.MIN_VALUE;  
        min = Integer.MAX_VALUE;  
  
        arr = new int[n];  
        operator = new int[4];  
  
        StringTokenizer st = new StringTokenizer(br.readLine());  
        for (int i = 0; i < n; i++) {  
            arr[i] = Integer.parseInt(st.nextToken());  
        }  
  
        st = new StringTokenizer(br.readLine());  
        for (int i = 0; i < 4; i++) {  
            operator[i] = Integer.parseInt(st.nextToken());  
        }  
  
        dfs(arr[0], 1);  
  
        System.out.println(max);  
        System.out.println(min);  
        br.close();  
    }  
  
    private static void dfs(int num, int idx) {  
        if (idx == n) {  
            max = Math.max(max, num);  
            min = Math.min(min, num);
            return;
        }  
  
        for (int i = 0; i < 4; i++) {  
            if (operator[i] <= 0) continue;  
            operator[i]--;  
  
            switch (i) {  
                case 0: dfs(num + arr[idx], idx + 1); break;  
                case 1: dfs(num - arr[idx], idx + 1); break;  
                case 2: dfs(num * arr[idx], idx + 1); break;  
                case 3: dfs(num / arr[idx], idx + 1); break;  
            }  
  
            operator[i]++;  
        }  
    }  
}