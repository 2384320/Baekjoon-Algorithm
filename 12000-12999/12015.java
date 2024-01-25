import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.StringTokenizer;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int n = Integer.parseInt(br.readLine());  
        int[] arr = new int[n];  
        int[] sort = new int[n];  
  
        StringTokenizer st = new StringTokenizer(br.readLine());  
        for (int i = 0; i < n; i++) {  
            arr[i] = Integer.parseInt(st.nextToken());  
        }  
  
        sort[0] = arr[0];  
        int length = 1;  
        for (int i = 1; i < n; i++) {  
            if (sort[length - 1] < arr[i]) {  
                length++;  
                sort[length - 1] = arr[i];  
            } else {  
                int left = 0;  
                int right = length;  
                while (left < right) {  
                    int mid = (left + right) / 2;  
                    if (sort[mid] < arr[i])  
                        left = mid + 1;  
                    else
	                    right = mid;  
                }  
                sort[left] = arr[i];  
            }  
        }  
        System.out.println(length);  
        br.close();  
    }  
}