package solution.classTest.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class test1654_1 {
	// 시간초과 로직
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		st = null;
		
		int[] arr = new int[K]; 
		
		long fsum = 0;
		
		for(int i = 0 ; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			fsum += arr[i];
		}
		
		long startNo = fsum/K;		
		
		int sum = 0;
		for(long i = startNo; i>=1; i--) {
			sum = 0;
			for(int j = 0 ; j<K; j++) {
				sum += arr[j]/i;
			}
			if(sum==N) {
				System.out.println(N);
				break;
			}
		}	
	}
}