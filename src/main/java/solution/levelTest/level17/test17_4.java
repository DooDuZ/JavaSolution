package solution.levelTest.level17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test17_4 {

    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for(int i = 0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(triangle(N)).append("\n");
        }

        System.out.println(sb);
    }

    public static long triangle(int N){
        if(dp[N]!=0){
            return dp[N];
        }
        dp[N] = triangle(N-1) + triangle( N-5);
        return dp[N];
    }
}