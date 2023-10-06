package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test1162 {
    // 도로포장 진행중

    static int INF = 1000000000;
    static int N;
    static int M;
    static int K;
    static ArrayList<ArrayList<CountEdge>> edges = new ArrayList<>();
    static PriorityQueue<CountEdge> pq = new PriorityQueue<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[N];

        Arrays.fill(dist, INF);

        for(int i = 0 ; i<N; i++){
            edges.add(new ArrayList<>());
        }

        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            edges.get(from).add(new CountEdge(to, cost, 0));
            edges.get(to).add(new CountEdge(from, cost, 0));
        }

        dist[0] = 0;
        pq.add(new CountEdge(0, 0, 0));

        dijkstra();

        System.out.println(dist[N-1]);
    }

    public static void dijkstra(){
        while (!pq.isEmpty()){
            CountEdge cur = pq.poll();

            if(dist[cur.v] != cur.c){ continue; }

            ArrayList<CountEdge> edgeList = edges.get(cur.v);

            for( CountEdge e : edgeList ){
                int totalCost = e.c;
                if(cur.step>=K){
                    totalCost += cur.c;
                }
                if( totalCost < dist[e.v]){
                    pq.add(new CountEdge(e.v, totalCost, cur.step+1));
                    dist[e.v] = totalCost;
                }
            }
        }
    }
}

class CountEdge implements Comparable<CountEdge> {
    int v;
    int c;
    int step;
    CountEdge(int v, int c, int step){
        this.v = v;
        this.c = c;
        this.step = step;
    }

    @Override
    public int compareTo(CountEdge e){
        return e.c-this.c;
    }
}

/*
2 2 1
1 2 10
2 1 51

 */