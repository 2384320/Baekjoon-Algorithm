import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 횟수
        int x1, y1, r1, x2, y2, r2;
        double distance, radiusPlus, radiusAbs;
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            radiusPlus = r1 + r2;
            radiusAbs = Math.abs(r2 - r1);
            
            if (x1 == x2 && y1 == y2 && r1 == r2) bw.write(-1 + "\n");
            else if (radiusPlus < distance) bw.write(0 + "\n");
            else if (radiusAbs > distance) bw.write(0 + "\n");
            else if (radiusAbs == distance) bw.write(1 + "\n");
            else if (radiusPlus == distance) bw.write(1 + "\n");
            else bw.write(2 + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}