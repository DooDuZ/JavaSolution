package solution.levelTest.level16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test16_1 {
	
	static int N;
	static int M;
		
	static int[] arr;
	static boolean[] checkdepth;
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		checkdepth = new boolean[N];
		
		dfs(0);
		
		System.out.println(sb);
		
	}
	
	public static void dfs(int depth) {
		
		if(M==depth) {
			for(int tmp : arr) {
				sb.append(tmp).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0 ; i<N; i++) {
			if(checkdepth[i]==false) {
				checkdepth[i] = true;
				arr[depth] = i+1;
				dfs(depth+1);
				
				checkdepth[i] = false;
			}
		}
	}
}
