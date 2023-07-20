import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int people = Integer.parseInt(st.nextToken());
        int party = Integer.parseInt(st.nextToken());
        int answer = 0;

        parent = new int[people + 1];
        for (int i = 1; i <= people; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowNum = Integer.parseInt(st.nextToken());

        boolean[] knowPeople = new boolean[51];
        for (int i = 0; i < knowNum; i++) {
            knowPeople[Integer.parseInt(st.nextToken())] = true;
        }

        List<Integer>[] peoples = new ArrayList[party];
        for (int i = 0; i < party; i++) {
            peoples[i] = new ArrayList<>();
        }

        int value, pre = 0;
        for (int i = 0; i < party; i++) {
            st = new StringTokenizer(br.readLine());
            knowNum = Integer.parseInt(st.nextToken());

            if (knowNum > 0) {
                pre = Integer.parseInt(st.nextToken());
                peoples[i].add(pre);
            }

            for (int j = 1; j < knowNum; j++) {
                value = Integer.parseInt(st.nextToken());
                peoples[i].add(value);
                union(pre, value);
                pre = value;
            }
        }

        int parent;
        for (int i = 1; i < knowPeople.length; i++) {
            if (knowPeople[i]) {
                knowPeople[find(i)] = true;
            }
        }

        for (int i = 0; i < party; i++) {
            if (peoples[i].size() > 0) {
                parent = find(peoples[i].get(0));
                if (!knowPeople[parent]) answer++;
            }
        }

        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int find(int x) {
        if (parent[x] == x) return parent[x] = x;
        return find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a > b) parent[a] = b;
            else parent[b] = a;
        }
    }
}