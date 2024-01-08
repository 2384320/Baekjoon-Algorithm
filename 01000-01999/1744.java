import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        List<Integer> posNums = new ArrayList<>();
        List<Integer> negNums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0)
                posNums.add(num);
            else
                negNums.add(num);
        }

        posNums.sort(Comparator.reverseOrder());
        Collections.sort(negNums);

        int posSize = posNums.size();
        for (int i = 0; i < posSize; i+=2) {
            if (posSize - i <= 1)
                answer += posNums.get(i);
            else {
                if (posNums.get(i) != 1 && posNums.get(i + 1) != 1)
                    answer += posNums.get(i) * posNums.get(i + 1);
                else
                    answer += posNums.get(i) + posNums.get(i + 1);
            }
        }

        int negSize = negNums.size();
        for (int i = 0; i < negSize; i+=2) {
            if (negSize - i <= 1)
                answer += negNums.get(i);
            else
                answer += negNums.get(i) * negNums.get(i + 1);
        }

        System.out.println(answer);
        br.close();
    }
}