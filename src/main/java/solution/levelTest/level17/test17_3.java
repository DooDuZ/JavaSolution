package solution.levelTest.level17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test17_3 {

    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;

        System.out.println(fibonacci(N));
    }

    public static int fibonacci(int N){

        if(dp[N]!=0){
            return dp[N];
        }
        dp[N] = ( fibonacci(N-1) + fibonacci( N-2 ) ) % 15746;
        return dp[N];
    }
}
