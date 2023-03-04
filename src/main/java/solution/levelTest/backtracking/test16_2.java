package solution.levelTest.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test16_2 {
	
	static int N;
	static int M;
		
	static int[] arr;
	
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs2(1, 0);
		
		System.out.println(sb);	
		
	}
	
	public static void dfs2(int start, int depth) {
		if(depth==M) {
			for(int tmp : arr) {
				sb.append(tmp).append(' ');
			}
			sb.append('\n');
			return;
		}		
		for(int i=start; i<=N; i++) {
			// System.out.println("깊이 : " + depth + "push값 : " + i);
			arr[depth] = i;
			dfs2(i+1, depth+1);
		}
	}
}



