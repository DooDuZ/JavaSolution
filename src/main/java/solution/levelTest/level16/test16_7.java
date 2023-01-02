package solution.levelTest.level16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test16_7 {
	static int N;
	static int[] sign;
	static int[] arr;

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for( int i = 0 ; i < N ; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		
		sign = new int[4];

		for(int i = 0; i<4; i++) {
			sign[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0,arr[0]);

		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int index, int value){
		if(index == N-1){
			max = Math.max(value, max);
			min = Math.min(value, min);
			return;
		}

		for(int i = 0; i<4; i++){
			if(sign[i]>0){
				sign[i]--;
				if(i==0){
					//System.out.println(i + "번째 계산 : " + value + "+" + arr[index+1]);
					dfs(index+1, value+arr[index+1]);
				}else if(i==1){
					//System.out.println(i + "번째 계산 : " +  value + "-" + arr[index+1]);
					dfs(index+1, value-arr[index+1]);
				}else if(i==2){
					//System.out.println(i + "번째 계산 : " +  value + "*" + arr[index+1]);
					dfs(index+1, value*arr[index+1]);
				}else if(i==3){
					//System.out.println(i + "번째 계산 : " +  value + "/" + arr[index+1]);
					dfs(index+1, value/arr[index+1]);
				}
				sign[i]++;
			}
		}
	}
}
