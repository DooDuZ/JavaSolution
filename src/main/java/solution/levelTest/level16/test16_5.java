package solution.levelTest.level16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class test16_5 {
	
	static int N;
	static int count = 0;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		dfs(0);
		
		System.out.println(count);
	}
	
	public static void dfs(int depth) {
		if(N==depth) {
			count++;
			return;
		}
		
		for(int i = 0 ; i<N; i++) {
			arr[depth] = i;
			if(isState(depth)) {
				dfs(depth+1);
			}
		}
	}
	
	public static boolean isState(int depth) {
		for(int i = 0 ; i<depth; i++) {
			if(arr[i]==arr[depth]) {
				return false;
			}else if( Math.abs(depth - i) == Math.abs(arr[i]-arr[depth]) ) {
				return false;
			}
		}	
		return true;
	}
}
