import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] sequence = new int[k];
        boolean[] isPlug = new boolean[k + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int plug = 0;
        for (int i = 0; i < k; i++) {
            if (isPlug[sequence[i]]) continue;

            if (plug < n) {
                plug++;
                isPlug[sequence[i]] = true;
            } else {
                List<Integer> list = new ArrayList<>();

                for (int j = i; j < k; j++) {
                    if (isPlug[sequence[j]] && !list.contains(sequence[j]))
                        list.add(sequence[j]);
                }

                if (list.size() != n) {
                    for (int j = 0; j <= k; j++) {
                        if (isPlug[j] && !list.contains(j)) {
                            isPlug[j] = false;
                            break;
                        }
                    }
                } else
                    isPlug[list.get(list.size() - 1)] = false;

                isPlug[sequence[i]] = true;
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}