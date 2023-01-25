import java.util.*;

public class Main {
    public static void main(String args[]) {
        int h, m;
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        m = sc.nextInt();
        m = m-45;

        if (m < 0) {
            h -= 1;
            if (h < 0) h = 23;
            m = 60 + m;
        }
        System.out.print(h + " "+ m);

    }
}