import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int redX, redY, blueX, blueY, holeX, holeY;
    private static int[] moveX = {-1, 0, 1, 0};
    private static int[] moveY = {0, 1, 0, -1};
    private static char[][] arr;
    private static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m][n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'R') {
                    redX = i;
                    redY = j;
                } else if (arr[i][j] == 'B') {
                    blueX = i;
                    blueY = j;
                } else if (arr[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                }
            }
        }

        bw.write(bfs() + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(redX, redY, blueX, blueY, 1));
        visited[redX][redY][blueX][blueY] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int curRx = node.redX;
            int curRy = node.redY;
            int curBx = node.blueX;
            int curBy = node.blueY;
            int count = node.count;

            if (count > 10)
                return -1;

            for (int i = 0; i < 4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedGoal = false;
                boolean isBlueGoal = false;
                while (arr[newRx + moveX[i]][newRy + moveY[i]] != '#') {
                    newRx += moveX[i];
                    newRy += moveY[i];

                    if (newRx == holeX && newRy == holeY) {
                        isRedGoal = true;
                        break;
                    }
                }

                while (arr[newBx + moveX[i]][newBy + moveY[i]] != '#') {
                    newBx += moveX[i];
                    newBy += moveY[i];

                    if (newBx == holeX && newBy == holeY) {
                        isBlueGoal = true;
                        break;
                    }
                }

                if (isBlueGoal)
                    continue;

                if (isRedGoal)
                    return count;

                if (newRx == newBx && newRy == newBy) {
                    if (i == 0) {
                        if (curRx > curBx)
                            newRx -= moveX[i];
                        else
                            newBx -= moveX[i];
                    } else if (i == 1) {
                        if (curRy < curBy)
                            newRy -= moveY[i];
                        else
                            newBy -= moveY[i];
                    } else if (i == 2) {
                        if (curRx < curBx)
                            newRx -= moveX[i];
                        else
                            newBx -= moveX[i];
                    } else {
                        if (curRy > curBy)
                            newRy -= moveY[i];
                        else
                            newBy -= moveY[i];
                    }
                }

                if (visited[newRx][newRy][newBx][newBy]) continue;
                visited[newRx][newRy][newBx][newBy] = true;
                queue.offer(new Node(newRx, newRy, newBx, newBy, count + 1));
            }
        }
        return -1;
    }
}

class Node {
    int redX, redY, blueX, blueY, count;

    Node(int redX, int redY, int blueX, int blueY, int count) {
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
        this.count = count;
    }
}