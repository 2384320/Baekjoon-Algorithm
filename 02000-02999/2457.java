import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.Arrays;  
import java.util.StringTokenizer;  
  
public class Main {  
    static class Flower implements Comparable<Flower> {  
        int start, end;  
  
        Flower(int start, int end) {  
            this.start = start;  
            this.end = end;  
        }  
  
        @Override  
        public int compareTo(Flower o) {  
            if (this.start == o.start)  
                return o.end - this.end;  
            return this.start - o.start;  
        }  
    }  
  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int n = Integer.parseInt(br.readLine());  
        Flower[] flowers = new Flower[n];  
  
        for (int i = 0; i < n; i++) {  
            StringTokenizer st = new StringTokenizer(br.readLine());  
            int startM = Integer.parseInt(st.nextToken());  
            int startD = Integer.parseInt(st.nextToken());  
            int endM = Integer.parseInt(st.nextToken());  
            int endD = Integer.parseInt(st.nextToken());  
  
            int start = startM * 100 + startD;  
            int end = endM * 100 + endD;  
            flowers[i] = new Flower(start, end);  
        }  
  
        Arrays.parallelSort(flowers);  
  
        int startDay = 301;  
        int endDay = 1201;  
        int idx = 0;  
        int max = 0;  
        int answer = 0;  
        while (startDay < endDay) {  
            boolean flag = false;  
            for (int i = idx; i < n; i++) {  
                if (flowers[i].start > startDay) break;  
  
                if (max < flowers[i].end) {  
                    flag = true;  
                    max = flowers[i].end;  
                    idx = i + 1;  
                }  
            }  
  
            if (flag) {  
                startDay = max;  
                answer++;  
            } else break;  
        }  
  
        if (max < endDay)  
            System.out.println(0);  
        else
	        System.out.println(answer);  
  
        br.close();  
    }  
}