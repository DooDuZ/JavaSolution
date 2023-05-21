package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int answer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i<=N; i++){
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value + arr[i-1];
        }

        int s = 0;
        int e = 0;

        while( s<=N ){
            if( arr[e]-arr[s] < S ){
                if(e==N){
                    s++;
                    continue;
                }
                e++;
                continue;
            }else if( arr[e]-arr[s] >= S ){
                answer = Math.min(e-s, answer);
            }
            s++;
        }

        if(answer==Integer.MAX_VALUE){
            answer = 0;
        }

        System.out.println(answer);
    }
}
