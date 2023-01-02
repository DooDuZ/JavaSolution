package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test15_8_2 {
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][K+1];
		
		System.out.println(binomialCoefficient(N, K));
		
	}
	
	public static int binomialCoefficient(int N, int K) {
		if(arr[N][K]>0) {
			return arr[N][K];
		}
		
		if(K==0 || N==K) {
			return arr[N][K] = 1;
		}
		return arr[N][K] = ( binomialCoefficient(N-1, K-1) + binomialCoefficient(N-1, K) )%10007;
	}
}