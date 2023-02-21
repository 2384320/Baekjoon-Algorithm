import java.util.*;

public class Main {
    public static void main(String args[]) {
        int h, m, cook, count;
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        m = sc.nextInt();
        cook = sc.nextInt();
        m += cook;

        if (m >= 60) {
            count = m / 60;
            for (int i = count; i > 0; i--) {
                h += 1;
            }
            if (h >= 24) h %= 24;
            m %= 60;
        }
        System.out.print(h + " " + m);
    }
}