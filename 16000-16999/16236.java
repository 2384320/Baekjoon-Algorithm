import java.io.*;
import java.util.*;

public class Main {
    static int n, sharkSize, sharkEatCount, answer;
    static int[] babyShark;
    static int[] moveX = {0, -1, 0, 1};
    static int[] moveY = {-1, 0, 1, 0};
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        sharkSize = 2;
        sharkEatCount = 0;
        babyShark = new int[2];
        answer = 0;
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    babyShark[0] = i;
                    babyShark[1] = j;
                    arr[i][j] = 0;
                }
            }
        }

        while (existFish()) {
            bfs(babyShark[0], babyShark[1]);
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        int[][] visited = new int[n][n];
        visited[x][y] = 0;

        while (!queue.isEmpty()) {
            int xx = queue.peek()[0];
            int yy = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = xx + moveX[i];
                int ny = yy + moveY[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] > 0) continue;
                if (arr[nx][ny] > sharkSize) continue;

                queue.add(new int[] {nx, ny});
                visited[nx][ny] = visited[xx][yy] + 1;
                if (arr[nx][ny] != 0 && arr[nx][ny] != sharkSize) {
                    answer += visited[nx][ny];
                    sharkEatCount++;
                    arr[nx][ny] = 0;
                    babyShark[0] = nx;
                    babyShark[1] = ny;

                    if (sharkEatCount == sharkSize) {
                        sharkEatCount = 0;
                        sharkSize++;
                    }

                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            System.out.print(visited[j][k] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("====");
                    return;
                }


            }
        }
    }

    private static boolean existFish() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] < sharkSize && arr[i][j] > 0) return true;
            }
        }
        return false;
    }
}