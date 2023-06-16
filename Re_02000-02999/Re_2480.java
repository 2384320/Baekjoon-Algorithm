import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int one = sc.nextInt();
        int two = sc.nextInt();
        int three = sc.nextInt();

        if (one == two) {
            if (two == three) System.out.print(10000 + one * 1000);
            else System.out.print(1000 + one * 100);
        } else {
            if (two == three) System.out.print(1000 + two * 100);
            else if (one == three) System.out.print(1000 + one * 100);
            else {
								int max;
                if (one > two && one > three) max = one;
                else if (two > three) max = two;
                else max = three;
								System.out.print(max * 100);
            }
        }
    }
}