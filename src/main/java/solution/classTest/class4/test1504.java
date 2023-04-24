package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test1504 {
    static int INF = 1000000000;
    static int N;
    static int E;

    static int v1;
    static int v2;

    static ArrayList<ArrayList<Edge>> edgeList = new ArrayList<>();

    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int chart[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        chart = new int[N];
        Arrays.fill(chart, INF);

        for(int i = 0 ; i<N; i++){
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

        st = new StringTokenizer(br.readLine());

        v1 = Integer.parseInt(st.nextToken())-1;
        v2 = Integer.parseInt(st.nextToken())-1;

        dijkstra(0,0);

        for(int tmp : chart){
            System.out.print(tmp + " ");
        }
        System.out.println();

        int v1Cost = chart[v1]; // v1을 먼저 방문할 떄의 변수
        int v2Cost = chart[v2]; // v2를 먼저 방문할 때의 변수

        // v1 -> v2 경로의 최단거리
        dijkstra(v1,v1Cost);

        for(int tmp : chart){
            System.out.print(tmp + " ");
        }
        System.out.println();

        v1Cost = chart[v2];
        dijkstra(v2,v1Cost);

        for(int tmp : chart){
            System.out.print(tmp + " ");
        }
        System.out.println();
        System.out.println();

        int min = chart[N-1];

        // v2 -> v1 경로의 최단거리
        dijkstra(v2,v2Cost);

        for(int tmp : chart){
            System.out.print(tmp + " ");
        }
        System.out.println();
        v2Cost = chart[v1];
        dijkstra(v1,v2Cost);

        for(int tmp : chart){
            System.out.print(tmp + " ");
        }
        System.out.println();


        min = Math.min(min, chart[N-1]);
        if(min==INF){ min = -1; }

        System.out.println(min);
    }

    public static void dijkstra(int sIdx, int sCost){
        Arrays.fill(chart, INF);
        pq.add(new Edge(sIdx, sCost));
        chart[sIdx] = sCost;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(chart[cur.v] != cur.c){ continue; }

            ArrayList<Edge> list = edgeList.get(cur.v);
            for(int i = 0 ; i<list.size(); i++){
                Edge next = list.get(i);
                int nextC = cur.c + next.c;
                if(nextC < chart[next.v]){
                    chart[next.v] = nextC;
                    pq.add( new Edge(next.v, nextC));
                }
            }
        }
    };
}

class Edge implements Comparable<Edge>{
    int v;
    int c;
    Edge(int v, int c){
        this.v = v;
        this.c = c;
    }

    @Override
    public int compareTo(Edge e){
        return this.c-e.c;
    }
}

/*
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
1 4

ans : 4

8 10
1 2 100
2 3 100
1 3 10
3 4 100
4 8 1000
1 5 100
5 6 100
1 6 10
6 7 100
7 8 1000
4 7

ans : 1330

 */