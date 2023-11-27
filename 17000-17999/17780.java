import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x, y, d;

        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        List<Integer>[][] spot = new ArrayList[n][n];
        Node[] horse = new Node[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                spot[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            if (d == 1)
                d = 2;
            else if (d == 2)
                d = 1;

            spot[x][y].add(i);
            horse[i] = new Node(x, y, d);
        }

        int answer = 0;
        boolean flag = true;
        while (flag) {
            answer++;
            if (answer > 1000) {
                answer = -1;
                break;
            }

            for (int i = 0; i < k; i++) {
                Node node = horse[i];
                int x = node.x;
                int y = node.y;

                if (spot[x][y].get(0) != i) continue;

                int nx = x + dx[node.d];
                int ny = y + dy[node.d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == 2) {
                    node.d = (node.d + 2) % 4;
                    nx = x + dx[node.d];
                    ny = y + dy[node.d];
                }

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == 2) {
                    continue;
                } else if (arr[nx][ny] == 1) {
                    for (int j = spot[x][y].size() - 1; j >= 0; j--) {
                        int tmp = spot[x][y].get(j);
                        spot[nx][ny].add(tmp);
                        horse[tmp].x = nx;
                        horse[tmp].y = ny;
                    }
                    spot[x][y].clear();
                } else {
                    for (int j = 0; j < spot[x][y].size(); j++) {
                        int tmp = spot[x][y].get(j);
                        spot[nx][ny].add(tmp);
                        horse[tmp].x = nx;
                        horse[tmp].y = ny;
                    }
                    spot[x][y].clear();
                }

                if (spot[nx][ny].size() >= 4) {
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}