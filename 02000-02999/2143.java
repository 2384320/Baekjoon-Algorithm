import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        int aLength = Integer.parseInt(br.readLine());
        int[] a = new int[aLength];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aLength; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int bLength = Integer.parseInt(br.readLine());
        int[] b = new int[bLength];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bLength; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        List<Long> aSum = setSumList(a, aLength);
        List<Long> bSum = setSumList(b, bLength);
        Collections.sort(aSum);
        bSum.sort(Comparator.reverseOrder());

        long answer = 0;
        int left = 0;
        int right = 0;
        while (left < aSum.size() && right < bSum.size()) {
            long getA = aSum.get(left);
            long getB = bSum.get(right);
            long s = getA + getB;

            if (t < s)
                right++;
            else if (t > s)
                left++;
            else {
                long aCount = 0;
                long bCount = 0;
                while (left < aSum.size() && getA == aSum.get(left)) {
                    left++;
                    aCount++;
                }

                while (right < bSum.size() && getB == bSum.get(right)) {
                    right++;
                    bCount++;
                }
                answer += aCount * bCount;
            }
        }
        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static List<Long> setSumList(int[] arr, int length) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            long sum = arr[i];
            list.add(sum);
            for (int j = i + 1; j < length; j++) {
                sum += arr[j];
                list.add(sum);
            }
        }
        return list;
    }
}