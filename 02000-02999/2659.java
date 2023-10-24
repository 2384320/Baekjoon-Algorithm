import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.StringTokenizer;  
  
class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());  
  
        int a = Integer.parseInt(st.nextToken());  
        int b = Integer.parseInt(st.nextToken());  
        int c = Integer.parseInt(st.nextToken());  
        int d = Integer.parseInt(st.nextToken());  
  
        int clockNum = getNum(a, b, c, d);  
        boolean[] isClockNum = getClockNum();  
        int answer = 0;  
        for (int i = 1111; i <= clockNum; i++) {  
            if (isClockNum[i])  
                answer++;  
        }  
        System.out.println(answer);  
        br.close();  
    }  
  
    private static int getNum(int a, int b, int c, int d) {  
        int num = Integer.MAX_VALUE;  
  
        num = Math.min(num, calculateNum(a, b, c, d));  
        num = Math.min(num, calculateNum(b, c, d, a));  
        num = Math.min(num, calculateNum(c, d, a, b));  
        num = Math.min(num, calculateNum(d, a, b, c));  
        return num;  
    }  
  
    private static int calculateNum(int a, int b, int c, int d) {  
        return a * 1000 + b * 100 + c * 10 + d;  
    }  
      
    private static boolean[] getClockNum() {  
        boolean[] arr = new boolean[10000];  
        for (int i = 1; i < 10; i++) {  
            for (int j = 1; j < 10; j++) {  
                for (int k = 1; k < 10; k++) {  
                    for (int l = 1; l < 10; l++) {  
                        int num = getNum(i, j, k, l);  
                        if (!arr[num])  
                            arr[num] = true;  
                    }  
                }  
            }  
        }  
        return arr;  
    }  
}