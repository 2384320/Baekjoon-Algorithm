import java.util.*;

public class Main {
    public static void main(String[] args) {
        int x, n, a, b;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            sum = a * b + sum;
        }

        if (sum == x) System.out.println("Yes");
        else if (sum != x) System.out.println("No");
    }
}