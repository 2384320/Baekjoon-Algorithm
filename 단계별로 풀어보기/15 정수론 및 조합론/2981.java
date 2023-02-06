import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int gcd = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        
        gcd = list.get(1) - list.get(0);
        for (int i = 1; i < n - 1; i++) {
            gcd = GCD(gcd, list.get(i+1) - list.get(i));
        }

        getDivisor(gcd);
        
        bw.flush();
        br.close();
        bw.close();
    }

    public static int GCD(int num1, int num2) {
        if (num1 % num2 == 0) return num2;
        else return GCD(num2, num1%num2);
    }
    
    public static void getDivisor(int num) throws IOException {
        List<Integer> listDivisor = new ArrayList<>();
        listDivisor.add(num);
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                listDivisor.add(i);
                if (num / i != i) listDivisor.add(num/i);
            }
        }
        Collections.sort(listDivisor);
        for (int i = 0; i < listDivisor.size(); i++) {
            bw.write(listDivisor.get(i) + " ");
        }
        
    }
}