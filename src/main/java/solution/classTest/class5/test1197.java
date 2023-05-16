package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test1197 {
    static int V;
    static int E;
    static ArrayList<ArrayList<Edge>> edgeList = new ArrayList<>();
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new boolean[V];

        for(int i = 0 ; i<V; i++){
            edgeList.add(new ArrayList<>());
        }

        for(int i = 0 ; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            edgeList.get(from).add(new Edge(to, cost));
            edgeList.get(to).add(new Edge(from, cost));
        }

        pq.add(new Edge(0,0));

        prim();

        System.out.println(answer);
    }

    static void prim(){
        for(int i = 0 ; i<V; i++){
            while(visited[pq.peek().v]){
                pq.poll();
            }
            Edge edge = pq.poll();
            visited[edge.v] = true;
            answer += edge.c;

            ArrayList<Edge> edges = edgeList.get(edge.v);

            for(int j = 0; j<edges.size(); j++){
                if( visited[edges.get(j).v] ){
                    continue;
                }
                pq.add(edges.get(j));
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int v;
    int c;

    Edge(int v, int c){
        this.v = v;
        this.c = c;
    }

    @Override
    public int compareTo(Edge e){
        return this.c - e.c;
    }
}

/*
5 5
1 4 3
2 3 3
4 3 5
2 1 6
4 5 9
 */