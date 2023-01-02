package solution.levelTest.level9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class test9_7_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		StringTokenizer st;
		for(int i = 0 ; i<N ;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (el1, el2)->{
			if(el1[0]==el2[0]) {
				return el1[1]-el2[1];
			}else {
				return el1[0]-el2[0];
			}
		});		
		for(int i = 0 ; i<N ; i++) {
			sb.append(arr[i][0]+" ").append(arr[i][1]+"\n");
		}
		System.out.println(sb);		
	}
}
