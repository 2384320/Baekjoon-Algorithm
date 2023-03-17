import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = br.readLine();
        int count = 0, pre_str = 32;

        for (int str : sentence.toCharArray()) {
            if (str == 32 && pre_str != 32) count++;
            pre_str = str;
        }
        if (pre_str != 32) count++;

        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }
}