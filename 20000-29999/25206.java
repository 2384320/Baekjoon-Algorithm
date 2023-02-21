import java.io.*;
import java.util.*;

import static java.lang.Float.NaN;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        double score, sum = 0.0, sumSubject = 0.0, resultZero = 0.0;
        String grade;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            score = Double.parseDouble(st.nextToken());
            grade = st.nextToken();
            if (grade.equals("P")) continue;
            sum += score;
            if (grade.equals("A+")) score *= 4.5;
            else if (grade.equals("A0")) score *= 4.0;
            else if (grade.equals("B+")) score *= 3.5;
            else if (grade.equals("B0")) score *= 3.0;
            else if (grade.equals("C+")) score *= 2.5;
            else if (grade.equals("C0")) score *= 2.0;
            else if (grade.equals("D+")) score *= 1.5;
            else if (grade.equals("D0")) score *= 1.0;
            else score *= 0.0;

            sumSubject += score;
        }
        bw.write(sumSubject/sum +"");
        bw.flush();
        br.close();
        bw.close();
    }
}