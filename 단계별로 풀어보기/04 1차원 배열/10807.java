import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, v, count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        v = Integer.parseInt(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            if (v == arr[i]) {
                count++;
            }
        }
        bw.write(count+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}