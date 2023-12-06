import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.LinkedList;  
import java.util.Queue;  
import java.util.StringTokenizer;  
  
public class Main {  
    static class Castle {  
        int x, y;  
  
        Castle(int x, int y) {  
            this.x = x;  
            this.y = y;  
        }  
    }  
  
    private static int[] dx = {0, 0, 1, -1};  
    private static int[] dy = {1, -1, 0, 0};  
  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());  
        int n = Integer.parseInt(st.nextToken());  
        int m = Integer.parseInt(st.nextToken());  
        int p = Integer.parseInt(st.nextToken());  
        int[] moveCount = new int[p + 1];  
        int[] answer = new int[p + 1];  
  
        st = new StringTokenizer(br.readLine());  
        for (int i = 1; i <= p; i++) {  
            moveCount[i] = Integer.parseInt(st.nextToken());  
        }  
  
        Queue<Castle>[] queue = new LinkedList[p + 1];  
        for (int i = 1; i <= p; i++) {  
            queue[i] = new LinkedList<>();  
        }  
  
        int[][] map = new int[n][m];  
        for (int i = 0; i < n; i++) {  
            String str = br.readLine();  
            for (int j = 0; j < m; j++) {  
                char ch = str.charAt(j);  
                if (ch == '.')  
                    map[i][j] = 0;  
                else if (ch == '#')  
                    map[i][j] = -1;  
                else {  
                    map[i][j] = ch - '0';  
                    queue[map[i][j]].offer(new Castle(i, j));  
                    answer[map[i][j]]++;  
                }  
            }  
        }  
  
        while (true) {  
            for (int i = 1; i <= p; i++) {  
                for (int j = 0; j < moveCount[i]; j++) {  
                    int size = queue[i].size();  
                    for (int k = 0; k < size; k++) {  
                        Castle castle = queue[i].poll();  
                        if (castle == null) break;  
  
                        for (int l = 0; l < 4; l++) {  
                            int nx = castle.x + dx[l];  
                            int ny = castle.y + dy[l];  
  
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;  
                            if (map[nx][ny] != 0) continue;  
                            map[nx][ny] = i;  
                            answer[map[nx][ny]]++;  
                            queue[i].offer(new Castle(nx, ny));  
                        }  
                    }  
                    if (queue[i].isEmpty()) break;  
                }  
            }  
            boolean flag = true;  
            for (int i = 1; i <= p; i++) {  
                if (!queue[i].isEmpty()) {  
                    flag = false;  
                    break;
                }  
            }  
            if (flag) break;  
        }  
  
        for (int i = 1; i <= p; i++) {  
            System.out.print(answer[i] + " ");  
        }  
        br.close();  
    }  
}