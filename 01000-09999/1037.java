import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int divisorCount = Integer.parseInt(br.readLine());
        int[] divisorArr = new int[divisorCount];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < divisorCount; i++) {
            divisorArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(divisorArr);
        bw.write(divisorArr[0] * divisorArr[divisorCount - 1] + "");

        bw.flush();
        br.close();
        bw.close();
    }
}