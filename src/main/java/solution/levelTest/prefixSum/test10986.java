package solution.levelTest.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test10986 {
    static long[] arr;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new long[N];
        long[] dp = new long[N+1];



        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2 ; i<N+1; i++){
            dp[i] = i-1 + dp[i-1];
        }

        st = new StringTokenizer(br.readLine());

        arr[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }

        int[] mode = new int[N];

        for(int i = 0 ; i<N; i++){
            mode[i] = (int) (arr[i]%M);     // 타입 변환 전에 연산 일어나도록 연산에 () 처리 필수!! 이것땜에 30분 날림...
        }

        Arrays.sort(mode);

        int same = 1;

        if(mode[0]==0){
            count++;
        }

        for(int i = 1 ; i<=N; i++){
            if(i==N){
                if(same>=2){
                    count += dp[same];
                }
                break;
            }

            if(mode[i]==0){
                count++;
            }
            if(mode[i]==mode[i-1]){
                same++;
            }else if(same>=2){
                count += dp[same];
                same = 1;
            }
        }
        System.out.println(count);
    }
}
