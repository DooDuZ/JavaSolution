package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1644 {

    static boolean[] primes = new boolean[4000001];
    static long[] prefixSum = new long[4000001];

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        primes[0] = true;
        primes[1] = true;

        for(int i = 2; i<=4000000; i++){
            if(primes[i]){
                prefixSum[i] = prefixSum[i-1];
                continue;
            }
            prefixSum[i] += (i + prefixSum[i-1]) ;
            for(int j = i*2; j<=4000000; j += i ){
                if(primes[j]){ continue; }
                primes[j] = true;
            }
        }

        searchN(N);

        System.out.println(answer);
    }
    public static void searchN(int N){
        int s = 0;
        int e = 0;

        while(s<4000000){
            if(prefixSum[e]-prefixSum[s] < N ){
                if(e<4000000){
                    e++;
                }else{
                    s++;
                }
            }else if(prefixSum[e]-prefixSum[s] > N ){
                s++;
            }else{
                if( (!primes[s] || s==1) && !primes[e]){
                    answer++;
                }
                s++;
            }
        }
    }
}
