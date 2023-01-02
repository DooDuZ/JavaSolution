package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

//결국 풀이 보고 해결... 
	//후에 꼭 다시 풀 것.

public class test15_5_4 {
	public static void main(String[] args) throws IOException{
		test15_5_4 test = new test15_5_4();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		for(int i = 0 ; i<T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int commonDivisor = arr[1]-arr[0];
		
		for(int i = 2; i<T; i++) {
			commonDivisor = test.commondivisor(commonDivisor, arr[i]-arr[i-1]);
		}
		
		for(int i = 2; i<=commonDivisor; i++) {
			if(commonDivisor%i==0) {
				sb.append(i).append(' ');
			}
		}
		System.out.println(sb);		
	}	
	public int commondivisor(int a, int b) {
		int rest = a%b;
		a = b;
		b = rest;		
		if(rest==0) {
			return a;
		}		
		return commondivisor(a,b);		
	}
}
