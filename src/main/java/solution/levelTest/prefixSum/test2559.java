package solution.levelTest.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        arr[0] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        int max = arr[K-1];

        for(int i = 0; i<N-K; i++){
            max = Math.max( max, arr[i+K] - arr[i] );
        }

        System.out.println(max);
    }
}
