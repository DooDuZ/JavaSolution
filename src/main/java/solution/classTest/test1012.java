package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1012 {
	
	static int[][] arr;
	static int count;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			arr = new int[N][M];
			count = 0;
			
			for(int j = 0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				arr[X][Y] = 1;
			}			
			
			for(int j = 0 ; j<N; j++) {				
				for(int k = 0; k<M; k++) {
					if(arr[j][k]==1) {
						checker(0,j,k);
					}
				}								
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void checker(int depth, int x, int y) {
		if(depth == 0) {
			count++;
		}		
		arr[x][y] = 2;
		if(x-1>=0 && arr[x-1][y] == 1 ) {
			checker(depth+1, x-1,y);
		}
		if(x+1<N && arr[x+1][y] == 1 ) {
			checker(depth+1, x+1,y);
		}
		if(y-1>=0 && arr[x][y-1] == 1 ) {
			checker(depth+1, x,y-1);
		}
		if(y+1<M && arr[x][y+1] == 1) {
			checker(depth+1, x,y+1);
		}
	}
}


