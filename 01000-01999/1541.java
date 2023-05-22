import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] minusArr = br.readLine().split("-");
        int[] arr = new int[minusArr.length];

        for (int i = 0; i < minusArr.length; i++) {
            String[] plusArr = minusArr[i].split("\\+");
            for (String p : plusArr) {
                arr[i] += Integer.parseInt(p);
            }
        }

        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer -= arr[i];
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}