import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.StringTokenizer;  
  
public class Main {  
    private static int n, l;  
    private static int[][] map;  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(br.readLine());  
        n = Integer.parseInt(st.nextToken());  
        l = Integer.parseInt(st.nextToken());  
        map = new int[n][n];  
  
        for (int i = 0; i < n; i++) {  
            st = new StringTokenizer(br.readLine());  
            for (int j = 0; j < n; j++) {  
                map[i][j] = Integer.parseInt(st.nextToken());  
            }  
        }  
  
        int answer = 0;  
        for (int i = 0; i < n; i++) {  
            if (checkHeightRoad(i))  
                answer++;  
            if (checkWidthRoad(i))  
                answer++;  
        }  
        System.out.println(answer);  
        br.close();  
    }  
  
    private static boolean checkHeightRoad(int y) {  
        boolean[] setting = new boolean[n];  
  
        for (int i = 0; i < n - 1; i++) {  
            int diff = map[i][y] - map[i + 1][y];  
  
            if (diff == 1) {  
                for (int j = 1; j <= l; j++) {  
                    if (i + j >= n || setting[i + j])  
                        return false;  
                    if (map[i][y] - 1 != map[i + j][y])  
                        return false;  
                    setting[i + j] = true;  
                }  
            } else if (diff == -1) {  
                for (int j = 0; j < l; j++) {  
                    if (i - j < 0 || setting[i - j])  
                        return false;  
                    if (map[i][y] != map[i - j][y])  
                        return false;  
                    setting[i - j] = true;  
                }  
            } else if (diff > 1 || diff < -1)  
                return false;  
        }  
        return true;  
    }  
  
    private static boolean checkWidthRoad(int x) {  
        boolean[] setting = new boolean[n];  
  
        for (int i = 0; i < n - 1; i++) {  
            int diff = map[x][i] - map[x][i + 1];  
  
            if (diff == 1) {  
                for (int j = 1; j <= l; j++) {  
                    if (i + j >= n || setting[i + j])  
                        return false;  
                    if (map[x][i] - 1 != map[x][i + j])  
                        return false;  
                    setting[i + j] = true;  
                }  
            } else if (diff == -1) {  
                for (int j = 0; j < l; j++) {  
                    if (i - j < 0 || setting[i - j])  
                        return false;  
                    if (map[x][i] != map[x][i - j])  
                        return false;  
                    setting[i - j] = true;  
                }  
            } else if (diff > 1 || diff < -1)  
                return false;  
        }  
        return true;  
    }  
}