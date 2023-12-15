import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.List;  

public class Main {  

    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int t = Integer.parseInt(br.readLine());  

        while (t-- > 0) {  
            int n = Integer.parseInt(br.readLine());  
            List<String> list = new ArrayList<>();  
            for (int i = 0; i < n; i++) {  
                list.add(br.readLine());  
            }  
            Collections.sort(list);  

            boolean flag = true;  
            for (int i = 0; i < n - 1; i++) {  
                if (list.get(i + 1).startsWith(list.get(i))) {  
                    flag = false;  
                    break;
                }  
            }  

            if (flag)  
                System.out.println("YES");  
            else
            System.out.println("NO");  
        }  
        br.close();  
    }  
}