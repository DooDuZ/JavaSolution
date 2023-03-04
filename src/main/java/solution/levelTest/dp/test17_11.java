package solution.levelTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test17_11 {
    static int N;
    static int[] arr;
    static Integer[] dp;

    static int max = Integer.MIN_VALUE;
    static int maxIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new Integer[N+2];

        for(int i = 1 ; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]>max){
                max = arr[i];
                maxIndex = i;
            }
        }

        dp[0] = 0;
        dp[1] = arr[1];
        if(N>=2){
            dp[2] = arr[1] + arr[2];
        }


        System.out.println(selectGrape(N));

    }

    public static int selectGrape( int position ){
        if(dp[position]==null){
            dp[position] =Math.max(Math.max(selectGrape(position-2), (selectGrape(position-3) + arr[position-1]) ) + arr[position], selectGrape(position-1));
        }
        return dp[position];
    }
}
/*
10
0
0
10
0
5
10
0
0
1
10
 */