import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        bw.write((int)Math.pow(2, n) - 1 + "\n");
        hanoi(n, 1, 3);

        bw.flush();
        br.close();
        bw.close();
    }
    static void hanoi(int n, int from, int to) throws IOException {
        if (n == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }

        int empty = 6 - from - to;
        hanoi(n-1, from, empty);
        bw.write(from + " " + to + "\n");
        hanoi(n-1, empty, to);
    }
}