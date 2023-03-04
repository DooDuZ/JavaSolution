package solution.levelTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test17_7 {
    static Integer[][] dp;
    static int N;
    static int[][] triangle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new Integer[N][N];
        triangle = new int[N][N];

        StringTokenizer st;

        for(int i = 0 ; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<=i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
                if(i==N-1){
                    dp[i][j] = triangle[i][j];
                }
            }
        }

        sumTriangle(0,0);
        System.out.println(dp[0][0]);
    }

    public static int sumTriangle(int depth, int position){
        if(dp[depth][position] == null){
            dp[depth][position] = triangle[depth][position]
                    + Math.max( sumTriangle(depth+1, position), sumTriangle(depth+1, position+1) );
        }
        return dp[depth][position];
    }
}
