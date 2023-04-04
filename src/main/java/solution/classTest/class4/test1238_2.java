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
    static final int INF = 1000000000;
    static int N;
    static int M;
    static int X;

    // 인접리스트로 변경 필요
    // 그렇지 않으면 간선의 개수가 아닌 정점의 개수만큼 계속 탐색하게된다.
    static int[][] costs;
    static int answer = Integer.MIN_VALUE;
    static int[] toX;
    static int[] fromX;

    static PriorityQueue<Integer[]> pq = new PriorityQueue<>( (e1,e2)->{
        return e1[1]-e2[1];
    } );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        costs = new int[N][N];

        toX = new int[N];
        fromX = new int[N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(costs[i], INF);
            costs[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            costs[from][to] = cost;
        }

        pq.add(new Integer[]{X,0});
        dijkstra(toX);

        // 간선 뒤집기
        for(int i = 0 ; i<N; i++){
            for(int j = 0 ; j<N; j++){
                int tmp = costs[i][j];
                costs[i][j] = costs[j][i];
                costs[j][i] = tmp;
            }
        }

        pq.add(new Integer[]{X,0});
        dijkstra(fromX);

        for(int i = 0; i<N; i++){
            answer = Math.max( toX[i] + fromX[i], answer );
        }

        System.out.println(answer);
    }

    public static void dijkstra(int[] chart){
        while(!pq.isEmpty()){

        }
    };
}
