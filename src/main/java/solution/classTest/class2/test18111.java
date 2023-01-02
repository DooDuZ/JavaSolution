package solution.classTest.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test18111 {

	static int[][] arr;
	static int N;
	static int M;
	static int B;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		


		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		int maxHeight=0;
		int minHeight=257;
		int time = Integer.MAX_VALUE;
		int lastHeight = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > maxHeight){
					maxHeight = arr[i][j];
				}
				if(arr[i][j] < minHeight){
					minHeight = arr[i][j];
				}
			}
		}

		for(int i = minHeight; i<=maxHeight; i++){
			int makeflat = makeFlat(i);
			if(makeflat <= time){
				time = makeflat;
				lastHeight = i;
			}
		}

		System.out.println(time+" "+lastHeight);
	}

	public static int makeFlat( int height ){

		int time = 0;
		int leftB = B;

		for(int i = 0; i<N; i++){
			for(int j = 0; j<M; j++){
				if(arr[i][j]>height){
					int value = arr[i][j] - height;
					time += (2*value);
					leftB += value;
				}else if(arr[i][j]<height){
					int value = height - arr[i][j];
					time += value;
					leftB-= value;
				}
			}
		}

		if(leftB<0){ return Integer.MAX_VALUE; }
		return time;
	}
}
/*
3 4 11
29 51 54 44
22 44 32 62
25 38 16 2


 */