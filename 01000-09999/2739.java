import java.util.*;

public class Main {
    public static void main(String[] args) {
        int i;
        Scanner sc = new Scanner(System.in);

        i = sc.nextInt();

        for (int j = 1; j <= 9; j++) {
            System.out.println(i + " * " + j + " = " + i*j);
        }
    }
}