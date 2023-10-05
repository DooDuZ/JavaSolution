package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test12865_2 {

    static int N;
    static int K;
    static int[] weights;
    static int[] values;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new Integer[N][K+1];

        weights = new int[N];
        values = new int[N];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(N-1, K));
    }

    public static int knapsack(int row, int col){

        if(row<0){
            return 0;
        }

        if(dp[row][col]!=null){
            return dp[row][col];
        }

        if(weights[row] > col){
            dp[row][col] = knapsack(row-1,col);
        }else{
            dp[row][col] = Math.max(knapsack(row-1,col), knapsack(row-1, col-weights[row] ) + values[row] );
        }

        return dp[row][col];
    }
}
