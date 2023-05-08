package solution.woowahan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Repair {

    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static long [] dist;
    static ArrayList<ArrayList<Edge>> edgeList = new ArrayList<>();

    public static void main(String[] args) {
        //int n = 6;
        int n = 4;
        dist = new long[n];

        // int[][] path = { {1,2}, {2,4}, {3,5},{5,6} };
        // int[][] repair = { {2,3,10}, {4,5,15} };

        int[][] path = { {1,2} };
        int[][] repair = { {1,3,10}, {2,3,15} };

        for(int i = 0 ; i<n; i++){
            edgeList.add(new ArrayList<>());
        }

        for(int i = 0 ; i<path.length; i++){
            int from = path[i][0]-1;
            int to = path[i][1]-1;

            edgeList.get(from).add((new Edge(to, 0)));
            edgeList.get(to).add((new Edge(from, 0)));
        }

        for(int i = 0 ; i<repair.length; i++){
            int from = repair[i][0]-1;
            int to = repair[i][1]-1;
            int cost = repair[i][2];

            edgeList.get(from).add((new Edge(to, cost)));
            edgeList.get(to).add((new Edge(from, cost)));
        }

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        pq.add(new Edge(0,0));
        dijkstra();

        long max = dist[0];

        for(int i = 0 ; i<n; i++){
            max = Math.max(max, dist[i]);
        }

        if(max==Long.MAX_VALUE){
            max = -1;
        }

        System.out.println(max);
    }

    public static void dijkstra() {
        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(dist[cur.v] != cur.c) continue;

            ArrayList<Edge> nextList = edgeList.get(cur.v);
            for(int i = 0 ; i<nextList.size(); i++){
                Edge next = nextList.get(i);
                int nextCost = next.c + cur.c;
                if( nextCost < dist[next.v] ) {
                    dist[next.v] = nextCost;
                    pq.add(new Edge(next.v, nextCost));
                }
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
    public int compareTo(Edge o) {
        return this.c - o.c;
    }
}