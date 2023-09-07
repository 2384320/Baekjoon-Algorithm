import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, answer;
    private static int[] moveX = {0, 0, 1, -1};
    private static int[] moveY = {1, -1, 0, 0};
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Queue<int[][]> queue = new LinkedList<>();
        queue.offer(board);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int q = 0; q < size; q++) {
                int[][] map = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int[][] copyM = new int[n][n];

                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            copyM[j][k] = map[j][k];
                        }
                    }

                    move(copyM, i);

                    queue.offer(copyM);
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            answer = Math.max(answer, copyM[j][k]);
                        }
                    }
                }
            }
            count++;
            if (count >= 5) return;
        }
    }

    private static void move(int[][] arr, int idx) {
        boolean[][] visited = new boolean[n][n];

        if (idx == 1 || idx == 3) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (arr[i][j] == 0) continue;

                    int x = i;
                    int y = j;
                    int temp = arr[x][y];
                    arr[x][y] = 0;

                    int nx = x + moveX[idx];
                    int ny = y + moveY[idx];

                    while (true) {
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;

                        if (arr[nx][ny] == 0) {
                            x = nx;
                            y = ny;
                            nx = x + moveX[idx];
                            ny = y + moveY[idx];
                        } else if (!visited[nx][ny] && arr[nx][ny] == temp) {
                            visited[nx][ny] = true;
                            x = nx;
                            y = ny;
                            break;
                        } else
                            break;
                    }
                    arr[x][y] += temp;
                }
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (arr[i][j] == 0) continue;

                    int x = i;
                    int y = j;
                    int temp = arr[x][y];
                    arr[x][y] = 0;

                    int nx = x + moveX[idx];
                    int ny = y + moveY[idx];

                    while (true) {
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;

                        if (arr[nx][ny] == 0) {
                            x = nx;
                            y = ny;
                            nx = x + moveX[idx];
                            ny = y + moveY[idx];
                        } else if (!visited[nx][ny] && arr[nx][ny] == temp) {
                            visited[nx][ny] = true;
                            x = nx;
                            y = ny;
                            break;
                        } else
                            break;
                    }
                    arr[x][y] += temp;
                }
            }
        }
    }
}