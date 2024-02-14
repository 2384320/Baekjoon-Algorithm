import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.StringTokenizer;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());  
        int n = Integer.parseInt(st.nextToken());  
        int m = Integer.parseInt(st.nextToken());  
        long answer = 0;  
        long[] s = new long[n + 1];  
        long[] count = new long[m];  
        st = new StringTokenizer(br.readLine());  
        for (int i = 1; i <= n; i++) {  
            s[i] = (s[i - 1] + Integer.parseInt(st.nextToken())) % m;  
  
            if (s[i] == 0)  
                answer++;  
  
            count[(int) s[i]]++;  
        }  
  
        for (int i = 0; i < m; i++) {  
            if (count[i] > 1)  
                answer += count[i] * (count[i] - 1) / 2;  
        }  
        System.out.println(answer);  
        br.close();  
    }  
}