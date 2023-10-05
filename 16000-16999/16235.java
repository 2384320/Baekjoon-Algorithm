import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] moveX = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] moveY = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] ground = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ground[i], 5);
        }

        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Tree> tree = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            tree.add(new Tree(x, y, z));
        }
        Collections.sort((List<Tree>) tree);

        while (k-- > 0) {
            List<Tree> dieTree = new ArrayList<>();

            spring(ground, tree, dieTree);
            summer(ground, dieTree);
            fall(n, tree);
            winter(n, ground, A);
        }
        System.out.println(tree.size());
        br.close();
    }

    private static void spring(int[][] ground, Queue<Tree> tree, List<Tree> dieTree) {
        int size = tree.size();
        while (size-- > 0) {
            Tree t = tree.poll();

            if (ground[t.x][t.y] < t.age)
                dieTree.add(t);
            else {
                ground[t.x][t.y] -= t.age;
                tree.offer(new Tree(t.x, t.y, t.age + 1));
            }
        }
    }

    private static void summer(int[][] ground, List<Tree> dieTree) {
        for (Tree die : dieTree) {
            ground[die.x][die.y] += die.age / 2;
        }
    }

    private static void fall(int n, Queue<Tree> tree) {
        List<Tree> oldTree = new ArrayList<>();
        int size = tree.size();
        while (size-- > 0) {
            Tree t = tree.poll();

            if (t.age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = t.x + moveX[i];
                    int ny = t.y + moveY[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                        continue;

                    tree.add(new Tree(nx, ny, 1));
                }
            }
            oldTree.add(t);
        }

        for (Tree t : oldTree) {
            tree.offer(t);
        }
    }

    private static void winter(int n, int[][] ground, int[][] A) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ground[i][j] += A[i][j];
            }
        }
    }
}

class Tree implements Comparable<Tree> {
    int x, y, age;

    Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }

    @Override
    public int compareTo(Tree o) {
        return Integer.compare(this.age, o.age);
    }
}