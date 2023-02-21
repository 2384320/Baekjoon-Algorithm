import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 횟수
        int startX, startY, endX, endY, planetCount, circleX, circleY, circleR, contain = 0;
        boolean containStart, containEnd;
        for (int i = 0; i < t; i++) {
            contain = 0;
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            planetCount = Integer.parseInt(br.readLine());
            for (int j = 0; j < planetCount; j++) {
                st = new StringTokenizer(br.readLine());
                circleX = Integer.parseInt(st.nextToken());
                circleY = Integer.parseInt(st.nextToken());
                circleR = Integer.parseInt(st.nextToken());

                containStart = containDot(startX, startY, circleX, circleY, circleR);
                containEnd = containDot(endX, endY, circleX, circleY, circleR);
                if ((containStart || containEnd) && !(containStart && containEnd)) contain++;
            }
            bw.write(contain + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    public static boolean containDot(int dotX, int dotY, int circleX, int circleY, int circleR) {
        return Math.sqrt(Math.pow(dotX - circleX, 2) + Math.pow(dotY - circleY, 2)) < circleR;
    }
}