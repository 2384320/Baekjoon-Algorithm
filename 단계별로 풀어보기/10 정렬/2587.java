import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(br.readLine());
            list.add(n);
            sum += n;
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(array);

        bw.write(sum/5 + "\n" + array[2]);

        bw.flush();
        br.close();
        bw.close();
    }
}