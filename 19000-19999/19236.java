import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        int[][] arr = new int[4][4];
        List<Fish> fishes = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()) - 1;

                fishes.add(new Fish(i, j, a, b, true));
                arr[i][j] = a;
            }
        }

        fishes.sort(Comparator.comparingInt(o -> o.id));

        Fish f = fishes.get(arr[0][0] - 1);
        Shark shark = new Shark(0, 0, f.dir, f.id);
        f.isAlive = false;
        arr[0][0] = -1;

        dfs(arr, shark, fishes);
        System.out.println(answer);
    }

    static void dfs(int[][] arr, Shark shark, List<Fish> fishes) {
        answer = Math.max(answer, shark.eatSum);

        fishes.forEach(e -> moveFish(e, arr, fishes));

        for (int dist = 1; dist < 4; dist++) {
            int nx = shark.x + dx[shark.dir] * dist;
            int ny = shark.y + dy[shark.dir] * dist;

            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && arr[nx][ny] > 0) {
                int[][] arrCopies = copyArr(arr);
                List<Fish> fishCopies = copyFishes(fishes);

                arrCopies[shark.x][shark.y] = 0;
                Fish f = fishCopies.get(arr[nx][ny] - 1);
                Shark newShark = new Shark(f.x, f.y, f.dir, shark.eatSum + f.id);
                f.isAlive = false;
                arrCopies[f.x][f.y] = -1;

                dfs(arrCopies, newShark, fishCopies);
            }
        }
    }

    static void moveFish(Fish fish, int[][] arr, List<Fish> fishes) {
        if (!fish.isAlive) return;

        for (int i = 0; i < 8; i++) {
            int nextDir = (fish.dir + i) % 8;
            int nx = fish.x + dx[nextDir];
            int ny = fish.y + dy[nextDir];

            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && arr[nx][ny] > -1) {
                arr[fish.x][fish.y] = 0;

                if (arr[nx][ny] == 0) {
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    Fish temp = fishes.get(arr[nx][ny] - 1);
                    temp.x = fish.x;
                    temp.y = fish.y;
                    arr[fish.x][fish.y] = temp.id;

                    fish.x = nx;
                    fish.y = ny;
                }

                arr[nx][ny] = fish.id;
                fish.dir = nextDir;
                return;
            }
        }
    }

    static int[][] copyArr(int[][] arr) {
        int[][] temp = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = arr[i][j];
            }
        }

        return temp;
    }

    static List<Fish> copyFishes(List<Fish> fishes) {
        List<Fish> temp = new ArrayList<>();
        fishes.forEach(e -> temp.add(new Fish(e.x, e.y, e.id, e.dir, e.isAlive)));
        return temp;
    }
}

class Shark {
    int x, y, dir, eatSum;

    Shark(int x, int y, int dir, int eatSum) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.eatSum = eatSum;
    }
}

class Fish {
    int x, y, id, dir;
    boolean isAlive;

    Fish(int x, int y, int id, int dir, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.dir = dir;
        this.isAlive = isAlive;
    }
}