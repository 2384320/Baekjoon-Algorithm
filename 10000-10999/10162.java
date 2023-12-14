import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int button1 = 0;
        int button2 = 0;
        int button3 = 0;

        while (t >= 300) {
            t -= 300;
            button1++;
        }

        while (t >= 60) {
            t -= 60;
            button2++;
        }

        while (t >= 10) {
            t -= 10;
            button3++;
        }

        if (t != 0)
            System.out.println(-1);
        else
            System.out.println(button1 + " " + button2 + " " + button3);
        br.close();
    }
}