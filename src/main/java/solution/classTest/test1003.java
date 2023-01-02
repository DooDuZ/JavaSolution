package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1003 {
	
	static int a = 0;
	static int b = 0;
	static StringBuilder sb;
	static int[] arr;
	static int[] countZero;
	static int[] countOne;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder(); 
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i = 0 ; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N==0) {
				sb.append(1).append(' ').append(0).append('\n');
				continue;
			}
			
			arr = new int[N+1];
			countZero = new int[N+1];
			countOne = new int[N+1];
			arr[0] = 0;
			arr[1] = 1;
			countZero[0] = 1;
			countOne[1] = 1;
			
			fibonacci(N);
			
			sb.append(a).append(' ').append(b).append('\n');
			
			a = 0;
			b = 0;
		}

		System.out.println(sb);
	}
	
	public static int fibonacci(int n) {
		a += countZero[n];
		b += countOne[n];
		if(n==0) {
			return arr[0];
		}
		
		if(arr[n]!=0) {
			return arr[n];
		}
		
		arr[n] = fibonacci(n-1) + fibonacci(n-2);
		countZero[n] = countZero[n-1]+countZero[n-2];
		countOne[n] = countOne[n-1]+countOne[n-2];
		
        return arr[n];	    
	}
}
