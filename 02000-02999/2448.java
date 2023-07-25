import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        check = new boolean[n][2 * n - 1];

        star(0, n - 1, n);

        for (boolean[] booleans : check) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) bw.write("*");
                else bw.write(" ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    
    private static void star(int x, int y, int n) {
        if (n == 3) {
            check[x][y] = true;
            check[x + 1][y - 1] = check[x + 1][y + 1] = true;
            check[x + 2][y - 2] = check[x + 2][y - 1] = check[x + 2][y] = check[x + 2][y + 1] = check[x + 2][y + 2] = true;
            return;
        }
        int size = n / 2;

        star(x, y, size);
        star(x + size, y - size, size);
        star(x + size, y + size, size);
    }
}