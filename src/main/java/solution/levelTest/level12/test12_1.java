package solution.levelTest.level12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


public class test12_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;		
		for(int i = 0; i<N; i++) {
			for(int j=i+1 ; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					int sums = arr[i]+arr[j]+arr[k];
					if(sums<=M && sums>=sum) {
						sum = sums;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
