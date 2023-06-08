import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = st.nextToken();
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        min = Math.min(min, getDistance(arr[i], arr[j], arr[k]));
                        if (min == 0) break;
                    }
                    if (min == 0) break;
                }
                if (min == 0) break;
            }
            bw.write(min+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int getDistance(String person1, String person2, String person3) {
        int sum = 0;
        sum += distance(person1, person2);
        sum += distance(person1, person3);
        sum += distance(person2, person3);
        return sum;
    }

    private static int distance(String person1, String person2) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (person1.charAt(i) != person2.charAt(i)) sum++;
        }
        return sum;
    }
}