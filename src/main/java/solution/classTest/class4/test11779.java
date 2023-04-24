package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test11779 {
    static int N;
    static int M;
    static int S;
    static int E;
    static ArrayList<ArrayList<Edge>> edgeList = new ArrayList<>();
    static int[] chart;
    static Integer[] pre;

    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static Stack<Integer> answerStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        chart = new int[N];
        pre = new Integer[N];
        Arrays.fill(chart, 1000000000);

        for(int i = 0 ; i<N; i++){
            edgeList.add(new ArrayList<>());
        }

        StringTokenizer st;

        for(int i = 0 ; i<M; i++){
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            edgeList.get(from).add(new Edge(to,cost));
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken())-1;
        E = Integer.parseInt(st.nextToken())-1;

        pq.add(new Edge(S,0));
        chart[S] = 0;
        dijkstra();

        int idx = E;
        while(true){
            answerStack.push(idx);
            if(pre[idx]==null){
                break;
            }
            idx = pre[idx];
        }

        StringBuilder sb = new StringBuilder();

        sb.append(chart[E]).append("\n");
        sb.append(answerStack.size()).append("\n");

        while(!answerStack.isEmpty()){
            sb.append(answerStack.pop()+1).append(" ");
        }

        System.out.println(sb);
    }

    public static void dijkstra(){
        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            System.out.println( (cur.v+1) + ", " + cur.c);
            if(chart[cur.v] != cur.c){ continue; }

            ArrayList<Edge> list = edgeList.get(cur.v);
            for(int i = 0 ; i<list.size(); i++){
                Edge next = list.get(i);
                int nextCost = cur.c + next.c;
                if(nextCost<chart[next.v]){
                    chart[next.v] = nextCost;
                    pre[next.v] = cur.v;
                    pq.add(new Edge(next.v, nextCost));
                }
            }
        }
    }
}
