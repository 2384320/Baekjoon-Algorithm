import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int answer;
    private static int[] moveX = {-1, 0, 1, 0};
    private static int[] moveY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        answer = 0;

        Shark[][] map = new Shark[r][c];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (d == 1)
                d = 0;
            else if (d == 4)
                d = 1;

            map[x][y] = new Shark(x, y, s, d, z);
        }

        int spot = 0;
        while (spot < c) {
            fishing(r, spot, map);

            Queue<Shark> sharks = new LinkedList<>();
            checkShark(r, c, map, sharks);

            map = new Shark[r][c];
            moveShark(r, c, map, sharks);
            spot++;
        }

        System.out.println(answer);
        br.close();
    }

    private static void fishing(int r, int spot, Shark[][] map) {
        for (int i = 0; i < r; i++) {
            if (map[i][spot] != null) {
                answer += map[i][spot].size;
                map[i][spot] = null;
                return;
            }
        }
    }

    private static void checkShark(int r, int c, Shark[][] map, Queue<Shark> sharks) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != null)
                    sharks.offer(new Shark(i, j, map[i][j].speed, map[i][j].distance, map[i][j].size));
            }
        }
    }

    private static void moveShark(int r, int c, Shark[][] map, Queue<Shark> sharks) {
        while (!sharks.isEmpty()) {
            Shark shark = sharks.poll();

            int speed = shark.speed;
            if (shark.distance == 0 || shark.distance == 2)
                speed %= (r - 1) * 2;
            else
                speed %= (c - 1) * 2;

            for (int i = 0; i < speed; i++) {
                int nx = shark.x + moveX[shark.distance];
                int ny = shark.y + moveY[shark.distance];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    shark.x -= moveX[shark.distance];
                    shark.y -= moveY[shark.distance];
                    shark.distance = (shark.distance + 2) % 4;
                    continue;
                }

                shark.x = nx;
                shark.y = ny;
            }

            if (map[shark.x][shark.y] != null) {
                if (map[shark.x][shark.y].size < shark.size)
                    map[shark.x][shark.y] = new Shark(shark.x, shark.y, shark.speed, shark.distance, shark.size);
            } else
                map[shark.x][shark.y] = new Shark(shark.x, shark.y, shark.speed, shark.distance, shark.size);
        }
    }
}

class Shark {
    int x, y, speed, distance, size;

    Shark(int x, int y, int speed, int distance, int size) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.distance = distance;
        this.size = size;
    }
}