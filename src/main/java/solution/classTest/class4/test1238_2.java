package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라로 재구현
// 반드시 완성할 것
public class test1238_2 {
    static class Edge implements Comparable<Edge> { // 간선 class
        int visit; // 다음 방문 위치
        int cost; // 비용
        @Override
        public int compareTo(Edge o) {
            return cost-o.cost;
        }

        Edge(int visit, int cost){
            this.visit = visit;
            this.cost = cost;
        }
    }
    static final int INF = 1000000000;
    static int N;
    static int M;
    static int X;
    static ArrayList<ArrayList<Edge>> edgeList = new ArrayList<>(); // 정방향 리스트
    static ArrayList<ArrayList<Edge>> reverseList = new ArrayList<>(); // 역방향 리스트
    static int answer = Integer.MIN_VALUE;
    static int[] toX;   // 파티에 가는 최소 비용
    static int[] fromX; // 파티에서 돌아오는 최소 비용
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;

        for(int i = 0 ; i<N; i++){
            edgeList.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        toX = new int[N];
        fromX = new int[N];

        // 비용 배열 초기화
        Arrays.fill(toX, INF);
        Arrays.fill(fromX, INF);
        toX[X] = 0;
        fromX[X] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            edgeList.get(from).add(new Edge(to, cost));
            reverseList.get(to).add(new Edge(from, cost));
        }

        // 정방향 다익스트라
        pq.add(new Edge(X, 0));
        dijkstra(edgeList, toX);

        // 역방향 다익스트라
        pq.add(new Edge(X, 0));
        dijkstra(reverseList, fromX);

        for(int i = 0; i<N; i++){
            answer = Math.max( toX[i] + fromX[i], answer );
        }

        System.out.println(answer);
    }

    public static void dijkstra(ArrayList<ArrayList<Edge>> edgeList, int[] chart){
        while(!pq.isEmpty()){
            Edge curE = pq.poll();

            int cur = curE.visit;
            int value = curE.cost;

            if(value!=chart[cur]) {continue;}

            ArrayList<Edge> edges = edgeList.get(cur);
            for(int i = 0 ; i<edges.size(); i++){
                Edge edge = edges.get(i);
                int nextValue = edge.cost+value;
                if(nextValue < chart[edge.visit] ){
                    chart[edge.visit] = nextValue;
                    pq.add(new Edge(edge.visit, nextValue));
                }
            }
        }
    }
}
/*
3 3 2
1 2 2
2 3 1
3 1 5
return 8

4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
return 10
 */