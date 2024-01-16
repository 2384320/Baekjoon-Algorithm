import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Problem implements Comparable<Problem> {
        int deadline, ramen;

        Problem(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.deadline == o.deadline)
                return o.ramen - this.ramen;
            return this.deadline - o.deadline;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Problem> problems = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            problems.add(new Problem(deadline, ramen));
        }

        Collections.sort(problems);

        long answer = 0;
        for (Problem problem : problems) {
            int size = pq.size();

            if (size < problem.deadline)
                pq.offer(problem.ramen);
            else if (size == problem.deadline) {
                int r = pq.peek();

                if (r < problem.ramen) {
                    pq.poll();
                    pq.offer(problem.ramen);
                }
            }
        }

        while (!pq.isEmpty())
            answer += pq.poll();
        System.out.println(answer);
        br.close();
    }
}