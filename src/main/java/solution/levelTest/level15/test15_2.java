package solution.levelTest.level15;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test15_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int C = Integer.parseInt(br.readLine());
		
		int[] arr = new int[C];
		
		st = new StringTokenizer(br.readLine());
		
		for( int i = 0 ; i<C; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		if(C==1) {
			System.out.println(arr[0]*arr[0]);
		}else {
			System.out.println(arr[0]*arr[C-1]);			 
		}		
	}
}
