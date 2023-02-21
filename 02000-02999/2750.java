import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(array);

        for (int i = 0; i < n; i++) {
            bw.write(array[i]+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}