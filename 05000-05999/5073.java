import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());
            if (num1 == 0) break;

            List<Integer> list = new ArrayList<>();
            list.add(num1);
            list.add(num2);
            list.add(num3);
            Collections.sort(list);

            if (list.get(0) + list.get(1) <= list.get(2))
                System.out.println("Invalid");
            else if (Objects.equals(list.get(0), list.get(2)))
                System.out.println("Equilateral");
            else if (Objects.equals(list.get(0), list.get(1))
                    || Objects.equals(list.get(1), list.get(2)))
                System.out.println("Isosceles");
            else
                System.out.println("Scalene");
        }
        br.close();
    }
}