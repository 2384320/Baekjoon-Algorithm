import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        String t = br.readLine();  
        String p = br.readLine();  
        kmp(t, p);  
        br.close();  
    }  
  
    private static void kmp(String context, String str) {  
        int[] table = makeTable(str);  
  
        int n = context.length();  
        int m = str.length();  
        int idx = 0;  
        int count = 0;  
        StringBuilder sb = new StringBuilder();  
  
        for (int i = 0; i < n; i++) {  
            while (idx > 0 && context.charAt(i) != str.charAt(idx)) {  
                idx = table[idx - 1];  
            }  
              
            if (context.charAt(i) == str.charAt(idx)) {  
                if (idx == m - 1) {  
                    sb.append(i - idx + 1).append(" ");  
                    count++;  
                    idx = table[idx];  
                } else  
                    idx += 1;  
            }  
        }  
        System.out.println(count);  
        System.out.println(sb);  
    }  
  
    private static int[] makeTable(String str) {  
        int n = str.length();  
        int[] table = new int[n];  
        int idx = 0;  
        for (int i = 1; i < n; i++) {  
            while (idx > 0 && str.charAt(i) != str.charAt(idx)) {  
                idx = table[idx - 1];  
            }  
  
            if (str.charAt(i) == str.charAt(idx))  
                table[i] = ++idx;  
        }  
        return table;  
    }  
}