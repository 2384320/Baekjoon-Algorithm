import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt() - 45;

        if (m < 0) {
            h -= 1;
            if (h < 0) h = 23;
            m += 60;
        }
        System.out.print(h + " "+ m);
    }
}