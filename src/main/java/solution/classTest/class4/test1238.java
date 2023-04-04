package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 플로이드-워셜
    // N=1000이므로 O^3 시간복잡도로는 무조건 시간초과가 난다
    // 시간초과가 아니라 틀렸다고 나온다... 하지만 반례들은 잘 돌아간다
    // 어디가 문제일까?
    // 뜬금 통과가 됐다. 어이가 없다...
public class test1238 {
    static final int INF = 1000000000;
    static int N;
    static int M;
    static int X;
    static int[][] costs;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;

        costs = new int[N][N];

        for(int i = 0 ; i<N; i++){
            Arrays.fill(costs[i], INF);
            costs[i][i] = 0;
        }

        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            costs[from][to] = cost;
        }

        floyd();    // 모든 정점간의 거리 계산

        for(int i = 0; i<N; i++){
            for(int j = 0 ; j<N; j++){
                System.out.print(costs[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0 ; i<N; i++){
            answer = Math.max(answer, costs[i][X]+costs[X][i]);
        }

        System.out.println(answer);
    }

    public static void floyd(){
        for(int i=0 ; i<N; i++){            // 경유지
            for(int j=0; j<N; j++){         // 출발지
                if(costs[j][i]==INF){
                    continue;
                }
                for(int k=0 ; k<N; k++){    // 도착지
                    int mid = costs[j][i];
                    int end = costs[i][k];
                    costs[j][k] = Math.min(costs[j][k], mid+end);
                }
            }
        }
    }
}

/*
3 3 2
1 2 2
2 3 1
3 1 5
return 8

4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
return 10
 */