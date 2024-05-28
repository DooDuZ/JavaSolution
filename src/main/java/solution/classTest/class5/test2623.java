package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test2623 {
    static int N;
    static int M;
    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static LinkedList<Edge> queue = new LinkedList<>();
    static LinkedList<Integer> answerQ = new LinkedList<>();
    static int[] inCount;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        input();
        StringBuilder sb = new StringBuilder();

        // 리프 노드 queue에 추가 하기
        for (int i = 0; i < N; i++) {
            if (inCount[i] != 0) {
                continue;
            }
            queue.add(new Edge(i));
        }

        topologySort();

        if (answerQ.size() != N){
            System.out.println(0);
            return;
        }

        while (!answerQ.isEmpty()){
            sb.append(answerQ.poll()).append('\n');
        }

        System.out.println(sb);
    }

    private static void topologySort() {
        while (!queue.isEmpty()) {

            Edge edge = queue.poll();

            if (inCount[edge.v] == 0 && !visited[edge.v]) {
                answerQ.add(edge.v+1);
                visited[edge.v] = true;

                ArrayList<Edge> next = edges.get(edge.v);
                for (Edge e : next) {
                    inCount[e.v]--;
                    queue.add(e);
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inCount = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int lng = Integer.parseInt(st.nextToken());

            int[] members = new int[lng];

            for (int j = 0; j < lng; j++) {
                members[j] = Integer.parseInt(st.nextToken()) - 1;
            }

            for (int j = 0; j < lng - 1; j++) {
                edges.get(members[j]).add(new Edge(members[j + 1]));
                inCount[members[j + 1]]++;
            }
        }
    }

    static class Edge {
        int v;

        Edge(int v) {
            this.v = v;
        }
    }
}

/*
6 3
3 1 4 3
4 6 2 5 4
3 2 3 1
 */