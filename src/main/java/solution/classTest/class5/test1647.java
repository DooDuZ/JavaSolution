package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test1647 {
    static int N;
    static int M;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static ArrayList<ArrayList<Edge>> edgeList = new ArrayList<>();

    static boolean[] visited;

    static int answer = 0;

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        for(int i = 0 ; i<N; i++){
            edgeList.add(new ArrayList<>());
        }

        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            edgeList.get(from).add(new Edge(to, cost));
            edgeList.get(to).add(new Edge(from, cost));
        }

        // 임의의 노드에서 시작
        pq.add(new Edge(0,0));

        prim();

        System.out.println(answer-max);
    }

    public static void prim(){
        for(int i = 0 ; i<N; i++){
            while ( visited[pq.peek().v] ){
                pq.poll();
            }
            Edge edge = pq.poll();
            visited[edge.v] = true;
            answer += edge.c;

            max = Math.max(max, edge.c);

            ArrayList<Edge> edges = edgeList.get(edge.v);

            for(Edge e : edges){
                if(visited[e.v]){
                    continue;
                }
                pq.add(e);
            }
        }
    }
}