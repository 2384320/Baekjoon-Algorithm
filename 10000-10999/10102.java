import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int a = str.replaceAll("B", "").length();
        int b = str.replaceAll("A", "").length();

        if (a > b)
            System.out.println("A");
        else if (a < b)
            System.out.println("B");
        else
            System.out.println("Tie");
        br.close();
    }
}