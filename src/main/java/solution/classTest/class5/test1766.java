package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test1766 {
    static ArrayList<Problem> problems = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            problems.add(new Problem(i));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            problems.get(from).out.add(problems.get(to));
            problems.get(to).in++;
        }

        topologySort();

        System.out.println(sb);
    }

    public static void topologySort() {
        PriorityQueue<Problem> pq = new PriorityQueue<>();

        for (Problem problem : problems) {
            if (problem.in == 0) {
                pq.add(problem);
            }
        }

        while (!pq.isEmpty()) {
            Problem problem = pq.poll();

            for (Problem next : problem.out) {
                next.in--;
                if (next.in == 0) {
                    pq.add(next);
                }
            }

            sb.append(problem.v+1).append(' ');
        }
    }
}

class Problem implements Comparable<Problem> {
    int v;
    int in = 0;
    ArrayList<Problem> out = new ArrayList<>();

    Problem(int v) {
        this.v = v;
    }

    @Override
    public int compareTo(Problem o) {
        return this.v - o.v;
    }
}