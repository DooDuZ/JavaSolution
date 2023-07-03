package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test4386 {
    static int N;
    static ArrayList<Node> nodeList = new ArrayList<>();
    static ArrayList<ArrayList<EdgeD>> edges = new ArrayList<>();
    static boolean[] visited;
    static double answer = 0;
    static PriorityQueue<EdgeD> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        StringTokenizer st;
        for(int i = 0 ; i< N; i++){
            st = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            nodeList.add(new Node(x, y));
            edges.add(new ArrayList<>());
        }

        for(int i = 0 ; i<N; i++){
            Node n = nodeList.get(i);
            for(int j = 0 ; j<N; j++){
                if(i==j){ continue; }
                Node next = nodeList.get(j);

                double d = getDistance(n, next);
                edges.get(i).add(new EdgeD(j, d));
                edges.get(j).add(new EdgeD(i, d));
            }
        }

        pq.add(new EdgeD(0,0));

        prim();

        System.out.printf("%.2f" , answer);
    }
    public static double getDistance(Node n1, Node n2){
        return Math.sqrt(Math.pow( n1.row-n2.row, 2 ) + Math.pow( n1.col-n2.col, 2 ));
    }

    public static void prim(){
        for(int i = 0; i<N; i++){
            while (visited[pq.peek().v]){
                pq.poll();
            }

            EdgeD cur = pq.poll();

            answer += cur.c;
            visited[cur.v] = true;

            ArrayList<EdgeD> nextList = edges.get(cur.v);

            for(EdgeD e : nextList){
                if(visited[e.v]){ continue; }
                pq.add(e);
            }
        }
    }
}

class Node{
    double row;
    double col;

    Node(double row, double col){
        this.row = row;
        this.col = col;
    }
}

class EdgeD implements Comparable<EdgeD>{
    int v;
    double c;

    EdgeD(int v, double c){
        this.v = v;
        this.c = c;
    }

    @Override
    public int compareTo( EdgeD o ){
        if(this.c > o.c){
            return 1;
        }else if(this.c < o.c){
            return -1;
        }
        return 0;
    }
}