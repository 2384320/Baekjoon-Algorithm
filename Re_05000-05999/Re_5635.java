import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        String name;
        int birth;

        Node(String name, int birth) {
            this.name = name;
            this.birth = birth;
        }

        @Override
        public int compareTo(Node o) {
            return this.birth - o.birth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            list.add(new Node(name, year * 1000 + month * 10 + day));
        }
        Collections.sort(list);

        System.out.println(list.get(n - 1).name);
        System.out.println(list.get(0).name);
        br.close();
    }
}