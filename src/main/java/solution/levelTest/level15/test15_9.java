package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test15_9 {
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st;
		
		for( int i = 0 ; i<T ; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			arr = new int[K+1][N+1];			
			
			System.out.println(binomialCoefficient(K, N));
		}
		
		
	}
	
	public static int binomialCoefficient(int N, int K) {
		if(arr[N][K]>0) {
			return arr[N][K];
		}
		
		if(K==0 || N==K) {
			return arr[N][K] = 1;
		}
		return arr[N][K] = ( binomialCoefficient(N-1, K-1) + binomialCoefficient(N-1, K) );
	}
}