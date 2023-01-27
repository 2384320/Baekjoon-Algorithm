import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] count = new int[10001];
        for (int i = 0; i < count.length; i++) {
            int n = d(i);
            if (n < 10001) count[n] = 1;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                System.out.println(i);
            }
        }
    }
    static int d(int number) {
        int sum = number;
        while (number != 0) {
            sum += (number % 10);
            number /= 10;
        }
        return sum;
    }
}