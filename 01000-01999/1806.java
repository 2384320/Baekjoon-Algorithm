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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (start < n) {
            if (sum >= s) {
                answer = Math.min(answer, end - start);
                sum -= arr[start];
                start++;
            } else if (end < n){
                sum += arr[end];
                end++;
            } else {
                sum -= arr[start];
                start++;
            }
        }

        answer = answer == Integer.MAX_VALUE ? 0 : answer;
        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }
}