import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num1 = new BigInteger(br.readLine());
        String str = br.readLine();
        BigInteger num2 = new BigInteger(br.readLine());

        if (str.equals("*"))
            System.out.println(num1.multiply(num2));
        else
            System.out.println(num1.add(num2));
        br.close();
    }
}