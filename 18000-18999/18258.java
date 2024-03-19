import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int start, end;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        start = 0;
        end = 0;
        arr = new int[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static void push(int num) {
        arr[end++] = num;
    }

    private static int pop() {
        int num = -1;
        if (empty() == 0)
            num = arr[start++];
        return num;
    }

    private static int size() {
        return end - start;
    }

    private static int empty() {
        if (size() > 0)
            return 0;
        return 1;
    }

    private static int front() {
        if (empty() == 1)
            return -1;
        return arr[start];
    }

    private static int back() {
        if (empty() == 1)
            return -1;
        return arr[end - 1];
    }
}