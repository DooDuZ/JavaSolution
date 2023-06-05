package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test1005 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i = 0; i<T; i++){
            ArrayList<ArrayList<EdgeA>> edges = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] count = new int[N];
            int[] delays = new int[N];

            for (int j = 0 ; j<N; j++) {
                edges.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                delays[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0; j<K; j++){
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken())-1;
                int to = Integer.parseInt(st.nextToken())-1;

                edges.get(from).add(new EdgeA(to, delays[to]));
                count[to]++;
            }

            int goal = Integer.parseInt(br.readLine())-1;

            LinkedList<Integer[]> queue = new LinkedList<>();

            for(int j = 0; j<N; j++){
                if(count[j]==0){
                    queue.add(new Integer[]{j, delays[j]});
                }
            }

            topologySort(count, edges, goal, queue, delays);
        }

        System.out.println(sb);
    }

    public static void topologySort(int[] count, ArrayList<ArrayList<EdgeA>> edges, int goal, LinkedList<Integer[]> queue, int[] delays){
        if(queue.isEmpty()){
            sb.append(delays[goal]).append("\n");
            return;
        }

        Integer[] cur = queue.poll();

        //System.out.println( (cur[0] + 1) + "을 방문했습니다.");
        //System.out.println("걸린 시간의 총 합은 " + cur[1] + " 입니다.");

        ArrayList<EdgeA> edgeList = edges.get(cur[0]);

        for (EdgeA e : edgeList){
            count[e.v]--;
            delays[e.v] = Math.max(delays[e.v], cur[1] + e.d);
            if(count[e.v]==0){
                queue.add(new Integer[]{ e.v, delays[e.v] });
            }
        }

        topologySort(count, edges, goal, queue, delays);
    }
}

class EdgeA{
    int v;
    int d;
    EdgeA(int v, int d){
        this.v = v;
        this.d = d;
    }
}

/*
1
4 4
10 100 1 10
1 2
1 3
2 4
3 4
4
 */