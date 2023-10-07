import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int answer;
    private static int[] moveX = {-1, 1, 0, 0};
    private static int[] moveY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        answer = 0;

        int[][] sharkSize = new int[r][c];
        Queue<Shark> sharks = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            sharkSize[x][y] = z;
            sharks.offer(new Shark(x, y, s, d, z));
        }

        int spot = 0;
        while (spot < c) {
            fishing(r, spot, sharkSize, sharks);
            moveShark(r, c, sharkSize, sharks);
            checkOverlap(sharkSize, sharks);
            spot++;
        }
        System.out.println(answer);
        br.close();
    }

    private static void fishing(int r, int spot, int[][] sharkSize, Queue<Shark> sharks) {
        for (int i = 0; i < r; i++) {
            if (sharkSize[i][spot] != 0) {
                answer += sharkSize[i][spot];
                removeShark(i, spot, sharkSize[i][spot], sharks);
                sharkSize[i][spot] = 0;
                return;
            }
        }
    }

    private static void removeShark(int x, int y, int size, Queue<Shark> sharks) {
        int s = sharks.size();

        while (s-- > 0) {
            Shark shark = sharks.poll();
            if (shark.x == x && shark.y == y && shark.size == size) {
                sharks.remove(shark);
                return;
            }
            sharks.offer(shark);
        }
    }

    private static void moveShark(int r, int c, int[][] sharkSize, Queue<Shark> sharks) {
        int size = sharks.size();
        while (size-- > 0) {
            Shark shark = sharks.poll();
            sharkSize[shark.x][shark.y] = 0;
            for (int i = 0; i < shark.speed; i++) {
                int nx = shark.x + moveX[shark.distance];
                int ny = shark.y + moveY[shark.distance];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    switch (shark.distance) {
                        case 0: shark.distance = 1; break;
                        case 1: shark.distance = 0; break;
                        case 2: shark.distance = 3; break;
                        case 3: shark.distance = 2; break;
                    }
                    i--;
                    continue;
                }

                shark.x = nx;
                shark.y = ny;
            }
            sharks.offer(shark);
        }
    }

    private static void checkOverlap(int[][] sharkSize, Queue<Shark> sharks) {
        int size = sharks.size();

        while (size-- > 0) {
            Shark shark = sharks.poll();

            if (sharkSize[shark.x][shark.y] == 0) {
                sharkSize[shark.x][shark.y] = shark.size;
                sharks.offer(shark);
            } else {
                if (sharkSize[shark.x][shark.y] < shark.size) {
                    removeShark(shark.x, shark.y, sharkSize[shark.x][shark.y], sharks);
                    sharkSize[shark.x][shark.y] = shark.size;
                    sharks.offer(shark);
                }
            }
        }
    }
}

class Shark implements Comparable<Shark> {
    int x, y, speed, distance, size;

    Shark(int x, int y, int speed, int distance, int size) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.distance = distance;
        this.size = size;
    }

    @Override
    public int compareTo(Shark o) {
        if (this.x == o.x)
            return this.y - o.y;
        return this.x - o.x;
    }
}