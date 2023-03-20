import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        String[] command, arr;
        String arrStr;
        Deque<String> answer;
        boolean isRight;

        x: while (t-- > 0) {
            // 명령어는 배열에 소분
            command = br.readLine().split("");
            // 배열 크기는 필요 없음.
            br.readLine();
            // String으로 입력된 배열을 변환하여 배열에 저장
            arrStr = br.readLine();
            arr = arrStr.substring(1, arrStr.length() - 1).split(",");
            // 배열을 deque로 변환
            answer = new ArrayDeque<>(Arrays.asList(arr));
            isRight = true;

            for (String com : command) {
                // 명령어가 R이면 뒤집기
                // 명령어가 D이면서, answer 크기가 0이거나, 첫 번째 원소가 공백이면, error 출력
                // 그렇지 않으면 첫 번째 원소 제거
                if (com.equals("R")) {
                    isRight = !isRight;
                    continue;
                }

                if (answer.size() != 0 && answer.getFirst().equals("")) {
                    bw.write("error\n");
                    continue x;
                }

                // 첫 원소가 없는 경우 error 출력
                if (isRight) {
                    if (answer.pollFirst() == null) {
                        bw.write("error\n");
                        continue x;
                    }
                } else {
                    if (answer.pollLast() == null) {
                        bw.write("error\n");
                        continue x;
                    }
                }
            }

            // 예제 출력에서 배열을 통채로 출력하는 방식이 아닌
            // 변환시켜서 출력하는 방식이라 다음과 같이 짰음.
            bw.write("[");
            if (answer.size() == 0) {
                bw.write("]\n");
                continue;
            }

            if (isRight) {
                bw.write(answer.pollFirst());
                while (!answer.isEmpty()) {
                    bw.write("," + answer.pollFirst());
                }
            } else {
                bw.write(answer.pollLast());
                while (!answer.isEmpty()) {
                    bw.write("," + answer.pollLast());
                }
            }
            bw.write("]\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}