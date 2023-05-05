import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                if (Math.abs(o1) == Math.abs(o2)) return Integer.compare(o1, o2);
                else return Integer.compare(Math.abs(o1), Math.abs(o2));
            }
        });

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) queue.add(x);
            else {
                if (queue.isEmpty()) bw.write(0 + "\n");
                else bw.write(queue.poll() + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}