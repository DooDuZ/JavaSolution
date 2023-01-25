package solution.levelTest.level17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test17_6 {
    static int[][] dp;
    static int N;
    static int[][] cost;
    // static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        cost = new int[N][3];
        // visited = new boolean[N][3];

        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        sumCost(N-1, 0);
        sumCost(N-1, 1);
        sumCost(N-1, 2);

        System.out.println(min);
    }

/*    static void dfs(int depth, int value, int color){
        if(depth == N){
            min = Math.min(value, min);
            return;
        }

        for(int i = 0; i<3; i++){
            if( !visited[depth][i] ){
                visited[depth][i] = true;
                dfs(depth+1, sumCost(depth, color), i);
                visited[depth][i] = false;
            }
        }
    }*/

    static int sumCost( int depth, int color ){
        if(dp[depth][color] == 0){
            if(color==0){
                dp[depth][color] = cost[depth][color] + Math.min( sumCost(depth-1, 1), sumCost(depth-1, 2) );
            }else if(color==1){
                dp[depth][color] = cost[depth][color] + Math.min( sumCost(depth-1, 0), sumCost(depth-1, 2) );
            }else {
                dp[depth][color] = cost[depth][color] + Math.min( sumCost(depth-1, 0), sumCost(depth-1, 1) );
            }
        }
        if(depth==N-1 && dp[depth][color]<min){
            min = dp[depth][color];
        }
        return dp[depth][color];
    }
}
