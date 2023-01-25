import java.util.*;

public class Main {
    public static void main(String[] args) {
        int one, two, three;
        Scanner sc = new Scanner(System.in);

        one = sc.nextInt();
        two = sc.nextInt();
        three = sc.nextInt();

        if (one == two) {
            if (two == three) System.out.print(10000 + one * 1000);
            else {
                System.out.print(1000 + one * 100);
            }
        }
        else { // one != two
            if (two == three) {
                System.out.print(1000 + two * 100);
            }
            else if (one == three) {
                System.out.print(1000 + one * 100);
            }
            else {
                if (one > two && one > three) System.out.print(one * 100);
                else if (two > three) System.out.print(two * 100);
                else System.out.print(three * 100);
            }
        }
    }
}