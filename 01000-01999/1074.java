import java.io.*;
import java.util.*;

public class Main {
    static int num, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        n = (int)Math.pow(2, n);
        num = 0;

        makeZ(0, 0, n, n);

        br.close();
    }

    public static void makeZ(int startR, int startC, int endR, int endC) {
        // 4분면의 한 변의 길이를 나타낼 length
        int length = (endR - startR) / 2;
        // 한 변의 길이가 1이라면 검사
        if (length == 1) {
            // r의 좌표와 c의 좌표의 홀짝을 검사
            // 1면: 짝 짝
            // 2면: 짝 홀 - num+1
            // 3면: 홀 짝 - num+2
            // 4면: 홀 홀 - num+3
            boolean rEven = r % 2 == 0;
            boolean cEven = c % 2 == 0;
            if (!rEven && !cEven) num += 3;
            else if (rEven && !cEven) ++num;
            else if (!rEven) num += 2;
            
            // 바로 출력되도록 함.
            System.out.println(num);
            System.exit(0);
        } else {
            // 좌표를 나타낼 midR, midC
            int midR = (startR + endR) / 2;
            int midC = (startC + endC) / 2;
            
            if (midR > r) {
                // 1면
                if (midC > c) makeZ(startR, startC, midR, midC);
                // 2면
                else {
                    num += length*length; // 1면 만큼의 num 더하기
                    makeZ(startR, midC, midR, endC);
                }
            } else {
                // 3면
                if (midC > c) {
                    num += length*length*2; // 1면, 2면 만큼의 num 더하기
                    makeZ(midR, startC, endR, midC);
                }
                // 4면
                else {
                    num += length*length*3; // 1면, 2면, 3면 만큼의 num 더하기
                    makeZ(midR, midC, endR, endC);
                }
            }
        }
    }
}