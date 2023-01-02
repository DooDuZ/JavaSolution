package solution.levelTest.level12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test12_3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		StringTokenizer st;
		for(int i = 0 ; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			int count = N;
			for(int j=0; j<N; j++) {
				if(i==j) {
					continue;
				}				
				if(arr[i][0]>arr[j][0] || arr[i][1] > arr[j][1]) {
					count--;
				}else if(arr[i][0]==arr[j][0] || arr[i][1]==arr[j][1]) {
					count--;
				}
			}
			sb.append(count).append(' ');
		}		
		System.out.println(sb);
	}
}

/*
  5
55 185
58 183
88 186
60 175
46 155
*/