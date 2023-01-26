import java.util.*;

public class Main {
    public static void main(String[] args) {
        int count, a, b;
        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}