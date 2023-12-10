import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.ArrayList;  
import java.util.LinkedList;  
import java.util.Queue;  
import java.util.StringTokenizer;  
  
public class Main {  
    static class Node {  
        int x;  
        int y;  
  
        public Node(int x, int y) {  
            this.x = x;  
            this.y = y;  
        }  
    }  
  
    private static int h, w, answer;  
    private static int[] dx = {-1, 1, 0, 0};  
    private static int[] dy = {0, 0, -1, 1};  
    private static boolean[] key;  
    private static ArrayList<Node>[] door;  
    private static char[][] arr;  
    private static boolean[][] visited;  
  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st;  
        StringBuilder sb = new StringBuilder();  
        int t = Integer.parseInt(br.readLine());  
  
        while (t-- > 0) {  
            st = new StringTokenizer(br.readLine());  
            h = Integer.parseInt(st.nextToken());  
            w = Integer.parseInt(st.nextToken());  
            answer = 0;  
            arr = new char[h + 2][w + 2];  
            door = new ArrayList[26];  
            key = new boolean[26];  
            visited = new boolean[h + 2][w + 2];  
            for (int i = 0; i < 26; i++) {  
                door[i] = new ArrayList<Node>();  
            }  
  
            for (int i = 0; i < h; i++) {  
                String[] data = br.readLine().split("");  
                for (int j = 0; j < w; j++) {  
                    arr[i + 1][j + 1] = data[j].charAt(0);  
                }  
            }  
  
  
            for (int i = 0; i < h + 2; i++) {  
                arr[i][0] = '.';  
                arr[i][w + 1] = '.';  
            }  
  
            for (int i = 0; i < w + 2; i++) {  
                arr[0][i] = '.';  
                arr[h + 1][i] = '.';  
            }  
  
            String[] str = br.readLine().split("");  
            for (int i = 0; i < str.length; i++) {  
                if (str[i].charAt(0) == '0') break;  
                key[str[i].charAt(0) - 'a'] = true;  
            }  
            bfs();  
            sb.append(answer).append("\n");  
        }  
  
        System.out.println(sb.toString());  
    }  
  
    public static void bfs() {  
        Queue<Node> queue = new LinkedList<>();  
  
        queue.add(new Node(0, 0));  
        visited[0][0] = true;  
  
        while (!queue.isEmpty()) {  
            Node node = queue.poll();  
  
            for (int d = 0; d < 4; d++) {  
                int nx = node.x + dx[d];  
                int ny = node.y + dy[d];  
  
                if (nx < 0 || nx >= (h + 2) || ny < 0 || ny >= (w + 2) || visited[nx][ny]) continue;  
                if (arr[nx][ny] == '*') continue;  
                if (arr[nx][ny] - 'A' >= 0 && arr[nx][ny] - 'A' <= 25) {  
                    if (key[arr[nx][ny] - 'A']) {  
                        visited[nx][ny] = true;  
                        arr[nx][ny] = '.';  
                        queue.add(new Node(nx, ny));  
                    } else  
                        door[arr[nx][ny] - 'A'].add(new Node(nx, ny));  
                } else if (arr[nx][ny] - 'a' >= 0 && arr[nx][ny] - 'a' <= 25) {  
                    int a = arr[nx][ny] - 'a';  
                    key[a] = true;  
                    arr[nx][ny] = '.';  
                    visited[nx][ny] = true;  
                    queue.add(new Node(nx, ny));  
  
                    for (Node doorNode : door[a]) {  
                        visited[doorNode.x][doorNode.y] = true;  
                        queue.add(new Node(doorNode.x, doorNode.y));  
                    }  
                } else if (arr[nx][ny] == '$') {  
                    arr[nx][ny] = '.';  
                    answer++;  
                    visited[nx][ny] = true;  
                    queue.add(new Node(nx, ny));  
                } else if (arr[nx][ny] == '.') {  
                    visited[nx][ny] = true;  
                    queue.add(new Node(nx, ny));  
                }  
            }  
        }  
    }  
  
}