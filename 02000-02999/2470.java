import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.Arrays;  
import java.util.StringTokenizer;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int n = Integer.parseInt(br.readLine());  
        int[] arr = new int[n];  
        StringTokenizer st = new StringTokenizer(br.readLine());  
  
        for (int i = 0; i < n; i++) {  
            arr[i] = Integer.parseInt(st.nextToken());  
        }  
        Arrays.sort(arr);  
  
        int left = 0;  
        int right = n - 1;  
        int min = Integer.MAX_VALUE;  
        int san = 0;  
        int al = 0;  
        while (left < right) {  
            int mix = arr[right] + arr[left];  
  
            if (min > Math.abs(mix)) {  
                min = Math.abs(mix);  
                san = arr[right];  
                al = arr[left];  
            }  
  
            if (mix > 0)  
                right--;  
            else
	            left++;  
        }  
        System.out.println(al + " " + san);  
        br.close();  
    }  
}