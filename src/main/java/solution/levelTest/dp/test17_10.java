package solution.levelTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test17_10 {
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1][10];
        dp[1][0] = 0;
        for(int i = 1 ; i < 10 ; i++){
            dp[1][i] = 1;
        }

        long answer = 0;

        for (int i = 0; i<=9; i++){
            answer += counting( N, i );
        }

        System.out.println(answer % 1000000000);
    }

    public static int counting(int length, int number){
        if(dp[length][number]==null){
            if(number==0) {
                dp[length][number] = counting(length-1, 1) % 1000000000 ;
            }else if(number==9){
                dp[length][number] = counting(length-1, 8) % 1000000000 ;
            }else{
                dp[length][number] = ( counting(length-1, number-1) + counting(length-1, number+1) ) % 1000000000 ;
            }
        }
        return dp[length][number];
    }
}
