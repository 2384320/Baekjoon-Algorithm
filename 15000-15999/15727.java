import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        if (l == 1) System.out.println(1);
        else System.out.println((l - 1) / 5 + 1);
    }
}