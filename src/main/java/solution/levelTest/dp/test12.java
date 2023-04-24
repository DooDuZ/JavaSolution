package solution.levelTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test12 {
    static int[] dp;
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i<N; i++){
            dp[i] = 1;
            for(int j = 0; j<i; j++){
                if( arr[i] > arr[j] ){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        Arrays.sort(dp);

        System.out.println(dp[N-1]);
    }
}

/*
11
100 1 2 3 101 4 5 6 102 7 8

 */