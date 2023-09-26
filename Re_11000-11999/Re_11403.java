import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.StringTokenizer;  

public class Main {  
    private static int n;  
    private static int[][] arr;  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        n = Integer.parseInt(br.readLine());  
        arr = new int[n][n];  
        
        for (int i = 0; i < n; i++) {  
            StringTokenizer st = new StringTokenizer(br.readLine());  
            for (int j = 0; j < n; j++) {  
                arr[i][j] = Integer.parseInt(st.nextToken());  
            }  
        }  
        
        floydWarshall();  
        
        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < n; j++) {  
                System.out.print(arr[i][j] + " ");  
            }  
            System.out.println();  
        }  
        br.close();  
    }  
    
    private static void floydWarshall() {  
        for (int k = 0; k < n; k++) {  
            for (int i = 0; i < n; i++) {  
                for (int j = 0; j < n; j++) {  
                    if (arr[i][k] == 1 && arr[k][j] == 1)  
                        arr[i][j] = 1;  
                }  
            }  
        }  
    }  
}