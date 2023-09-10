import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int idx = 0;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    int x = Integer.parseInt(st.nextToken());
                    arr[idx++] = x;
                    break;
                case 2:
                    if (idx == 0) bw.write(-1 + "\n");
                    else {
                        bw.write(arr[--idx] + "\n");
                        arr[idx] = 0;
                    }
                    break;
                case 3:
                    bw.write(idx + "\n");
                    break;
                case 4:
                    if (idx == 0) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
                case 5:
                    if (idx == 0) bw.write(-1 + "\n");
                    else bw.write(arr[idx - 1] + "\n");
                    break;
            }
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}