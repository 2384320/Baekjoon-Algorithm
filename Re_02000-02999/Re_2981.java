import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int gcd = arr[1] - arr[0];
        for (int i = 1; i < n - 1; i++) {
            gcd = GCD(gcd, arr[i+1] - arr[i]);
        }
        getDivisor(gcd);

        br.close();
    }

    public static int GCD(int num1, int num2) {
        if (num1 % num2 == 0) return num2;
        else return GCD(num2, num1%num2);
    }

    public static void getDivisor(int num) {
        List<Integer> listDivisor = new ArrayList<>();
        listDivisor.add(num);
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                listDivisor.add(i);
                if (num / i != i) listDivisor.add(num/i);
            }
        }
        Collections.sort(listDivisor);
        for (int n : listDivisor) {
            System.out.print(n + " ");
        }
    }
}