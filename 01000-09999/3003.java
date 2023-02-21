import java.util.*;

public class Main {
    public static void main(String args[]) {
        int king, queen, rook, bishop, knight, pawn;

        Scanner sc = new Scanner(System.in);
        king = sc.nextInt();
        queen = sc.nextInt();
        rook = sc.nextInt();
        bishop = sc.nextInt();
        knight = sc.nextInt();
        pawn = sc.nextInt();

        System.out.print(1-king);System.out.print(" ");
        System.out.print(1-queen);System.out.print(" ");
        System.out.print(2-rook);System.out.print(" ");
        System.out.print(2-bishop);System.out.print(" ");
        System.out.print(2-knight);System.out.print(" ");
        System.out.print(8-pawn);
    }
}