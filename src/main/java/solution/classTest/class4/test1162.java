package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test1162 {
    // 도로포장 진행중
        // 메모리 초과가 난다,, ,어디서 어떻게...?

    static int INF = 1000000000;
    static int N;
    static int M;
    static int K;
    static ArrayList<ArrayList<CountEdge>> edges = new ArrayList<>();
    static PriorityQueue<CountEdge> pq = new PriorityQueue<>();
    static long[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new long[N][K+1];

        for(int i = 0 ; i<N; i++){
            Arrays.fill(dist[i], INF);
        }

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

        dist[0][0] = 0;

        pq.add(new CountEdge(0, 0, 0));

        dijkstra();

        long answer = Long.MAX_VALUE;

        for(int i = 0; i<=K; i++){
            answer = Math.min(dist[N-1][i], answer);
        }

        System.out.println(answer);
    }

    public static void dijkstra(){
        while (!pq.isEmpty()){
            CountEdge cur = pq.poll();

            if(dist[cur.v][cur.count] != cur.c){ continue; }

            for( CountEdge e : edges.get(cur.v) ){
                if(cur.count<K && cur.c < dist[e.v][cur.count+1] ){
                    pq.add(new CountEdge(e.v, cur.c, cur.count+1));
                    dist[e.v][cur.count+1] = cur.c;
                }

                if(e.c+cur.c < dist[e.v][cur.count]){
                    pq.add(new CountEdge(e.v, e.c+cur.c, cur.count));
                    dist[e.v][cur.count] = cur.c+e.c;
                }
            }
        }
    }
}

class CountEdge implements Comparable<CountEdge> {
    int v;
    long c;
    int count;
    CountEdge(int v, long c, int count){
        this.v = v;
        this.c = c;
        this.count = count;
    }

    @Override
    public int compareTo(CountEdge e){
        if(e.c>this.c){
            return 1;
        }else if(e.c<this.c){
            return -1;
        }
        return 0;
    }
}

/*
2 2 1
1 2 10
2 1 51

0
 */