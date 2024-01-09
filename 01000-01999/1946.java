import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.List;  
import java.util.StringTokenizer;  
  
public class Main {  
    static class Node implements Comparable<Node> {  
        int a, b;  
  
        Node(int a, int b) {  
            this.a = a;  
            this.b = b;  
        }  
  
        @Override  
        public int compareTo(Node o) {  
            return this.a - o.a;  
        }  
    }  
  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int t = Integer.parseInt(br.readLine());  
  
        while (t-- > 0) {  
            int n = Integer.parseInt(br.readLine());  
            int answer = 1;  
            List<Node> list = new ArrayList<>();  
  
            for (int i = 0; i < n; i++) {  
                StringTokenizer st = new StringTokenizer(br.readLine());  
                int a = Integer.parseInt(st.nextToken());  
                int b = Integer.parseInt(st.nextToken());  
  
                list.add(new Node(a, b));  
            }  
  
            Collections.sort(list);  
  
            int rankB = list.get(0).b;  
            for (Node score : list) {  
                if (rankB > score.b) {  
                    answer++;  
                    rankB = score.b;  
                }  
            }  
  
            System.out.println(answer);  
        }  
        br.close();  
    }  
}