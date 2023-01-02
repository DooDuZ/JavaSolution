package solution.levelTest.level14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class test14_3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			
			if(arr[0]==0) {
				break;
			}
			
			Arrays.sort(arr);
			
			if(arr[0]*arr[0] + arr[1]*arr[1] == arr[2]*arr[2]) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
		}		
	}
}
