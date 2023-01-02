package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1654_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		
		long max = 0;
		long min = 0;
		
		for(int i = 0 ; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		max++;
		
		long count = 0;
		
		while(min<max) {
			count = 0;
			long mid = (max+min)/2;
			
			for(int i = 0 ; i<K; i++) {
				count += arr[i]/mid;
			}
			
			if(count<N) {
				max = mid;
			}else {
				min = mid+1;
			}
		}
		System.out.println(max-1);
	}
}

/*
 	4 11
	802
	743
	457
	539
 */
