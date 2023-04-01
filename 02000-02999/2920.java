import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num, priorNum, answer = 0;

        priorNum = Integer.parseInt(st.nextToken());
        for (int i = 1; i < 8; i++) {
            num = Integer.parseInt(st.nextToken());
            if (priorNum - num > 0) answer--;
            else if (priorNum - num < 0) answer++;
            priorNum = num;
        }
        if (answer == 7) bw.write("ascending");
        else if (answer == -7) bw.write("descending");
        else bw.write("mixed");

        bw.flush();
        br.close();
        bw.close();
    }
}