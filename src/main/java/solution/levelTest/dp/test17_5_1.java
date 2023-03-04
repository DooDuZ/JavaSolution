package solution.levelTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 메모리 초과
// 메모리제한 128MB, 0<=N<=100000
// N이 10인 경우 2차원 배열인 dp에 필요한 최소 메모리값 (int 4byte * 100억)
// dp 배열 조정 필요
public class test17_5_1 {
    static Integer[][] dp;
    static int[] arr;
    static int N;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new Integer[N][N];
        arr = new int[N];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = arr[i];
        }

        for(int i = 0; i<N; i++){
            sectionCount(i, N-1);
        }

        System.out.println(max);
    }

    public static int sectionCount( int startIndex, int endIndex){
        if(dp[startIndex][endIndex]==null){
            dp[startIndex][endIndex] = arr[endIndex] + sectionCount(startIndex, endIndex-1);
        }
        if(max<dp[startIndex][endIndex]){
            max = dp[startIndex][endIndex];
        }
        return dp[startIndex][endIndex];
    }
}
