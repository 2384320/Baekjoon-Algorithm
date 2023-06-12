import java.io.*;
import java.util.*;

// 예제 6번 빼고 잘 돌아가는 중간 저장 코드 -> 물고기 지정이 문제
public class Main {
    private static final int[] moveX = {0, 0, 1, -1};
    private static final int[] moveY = {1, -1, 0, 0};
    private static int[][] sea;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        sea = new int[n][n];

        int[] info = {0, 0, 2, 0, 0};
        int time = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    info[0] = i;
                    info[1] = j;
                    sea[i][j] = 0;
                }
            }
        }

        while (checkFish(info[2])) {
            info = bfs(info[0], info[1], info[2], info[3], info[4]);
            time += info[4];
            System.out.println(Arrays.toString(info));
        }

        bw.write(time + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int[] bfs(int x, int y, int size, int eatCount, int time) {
        boolean flag = false;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[sea.length][sea.length];
        visited[x][y] = 1;

        List<int[]> EdibleFish = findEdibleFish(size);
        int[] coordinate = findNearbyFish(EdibleFish, x, y);

        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = moveX[i] + x;
                int ny = moveY[i] + y;

                if (nx < 0 || ny < 0 || nx >= sea.length || ny >= sea.length) continue;
                if (visited[nx][ny] != 0) continue;
                if (sea[nx][ny] > size) continue;

                visited[nx][ny] = visited[x][y] + 1;
                queue.offer(new int[] {nx, ny});

                if (coordinate[0] == nx && coordinate[1] == ny) {
                    sea[nx][ny] = 0;
                    eatCount++;
                    if (eatCount == size) {
                        size++;
                        eatCount = 0;
                    }
                    x = nx;
                    y = ny;
                    flag = true;
                    time = visited[nx][ny] - 1;
                    break;
                }

            }
            if (flag) break;
        }

        return new int[] {x, y, size, eatCount, time};
    }

    private static int[] findNearbyFish(List<int[]> fish, int x, int y) {
        int minDis = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] f : fish) {
            if (Math.abs(f[0] - x) + Math.abs(f[1] - y) == minDis) {
                if (minX != f[0]) {
                    minX = Math.min(minX, f[0]);
                    minY = minX == f[0] ? f[1] : minY;
                }
                else {
                    minY = Math.min(minY, f[1]);
                    minX = minY == f[1] ? f[0] : minX;
                }
            } else if (Math.abs(f[0] - x) + Math.abs(f[1] - y) < minDis) {
                minX = f[0];
                minY = f[1];
                minDis = Math.abs(f[0] - x) + Math.abs(f[1] - y);
            }
        }

        return new int[] {minX, minY};
    }

    private static List<int[]> findEdibleFish(int size) {
        List<int[]> fish = new ArrayList<>();
        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < sea.length; j++) {
                if (sea[i][j] < size && sea[i][j] != 0) {
                    fish.add(new int[]{i, j});
                }
            }
        }

        return fish;
    }

    private static boolean checkFish(int size) {
        for (int[] ints : sea) {
            for (int anInt : ints) {
                if (anInt < size && anInt != 0) return true;
            }
        }
        return false;
    }
}