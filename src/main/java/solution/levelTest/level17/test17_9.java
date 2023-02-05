package solution.levelTest.level17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test17_9 {
    static int N;
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new Integer[N+1];

        for(int i = 1 ; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if(N>=2){
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(upStair(N));
    }

    public static int upStair( int floor ){
        if(dp[floor]==null){
            dp[floor] = Math.max(upStair(floor-2), (upStair(floor-3) + arr[floor-1]) ) + arr[floor];
        }
        return dp[floor];
    }
}
