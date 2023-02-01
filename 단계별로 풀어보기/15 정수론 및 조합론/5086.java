import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num1, num2;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            if (num1 == 0 && num2 == 0) break;
            bw.write(factorOrMultiple(num1, num2) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    public static String factorOrMultiple(int num1, int num2) {
        if (num1 % num2 == 0) return "multiple";
        else if (num2 % num1 == 0) return "factor";
        return "neither";
    }
}