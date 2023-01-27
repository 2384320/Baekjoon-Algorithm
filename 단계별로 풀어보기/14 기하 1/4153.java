import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int side1 = Integer.parseInt(st.nextToken());
            int side2 = Integer.parseInt(st.nextToken());
            int side3 = Integer.parseInt(st.nextToken());

            if (side1 == 0 && side2 == 0 && side3 == 0) break;
            is_triangle(side1, side2, side3);
        }
        bw.flush();
        br.close();
        bw.close();
    }
    public static void is_triangle(int num1, int num2, int num3) throws IOException {
        int[] arr = {num1, num2, num3};
        Arrays.sort(arr);
        if (Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2)) bw.write("right\n");
        else bw.write("wrong\n");
        return;
    }
}