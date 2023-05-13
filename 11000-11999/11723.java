import java.io.*;
import java.util.*;

public class Main {
    static int idx, select;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        arr = new int[20];

        idx = 0;
        select = 0;
        int num = 0;
        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    add(num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    remove(num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if (check(num)) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    toggle(num);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void add(int num) {
        if (check(num)) return;
        arr[idx++] = num;
    }
    public static void remove(int num) {
        if (!check(num)) return;
        for (int i = select; i < idx - 1; i++) {
            arr[i] = arr[i+1];
        }
        arr[--idx] = 0;
    }
    public static boolean check(int num) {
        for (int i = 0; i < idx; i++) {
            if (arr[i] == num) {
                select = i;
                return true;
            }
        }
        return false;
    }
    public static void toggle(int num) {
        if (check(num)) remove(num);
        else add(num);
    }
    public static void all() {
        arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        idx = 20;
    }
    public static void empty() {
        arr = new int[20];
        idx = 0;
    }
}