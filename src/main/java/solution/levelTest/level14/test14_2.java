package solution.levelTest.level14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test14_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] arr = new int[4][2];
		
		for(int i = 0 ; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int answerx = -1;
		int answery = -1;
		
		if(arr[0][0]==arr[1][0]) {
			answerx = arr[2][0];
		}else if(arr[0][0] == arr[2][0]) {
			answerx = arr[1][0];
		}else if(arr[1][0] == arr[2][0]) {
			answerx = arr[0][0];
		}
		
		if(arr[0][1]==arr[1][1]) {
			answery = arr[2][1];
		}else if(arr[0][1] == arr[2][1]) {
			answery = arr[1][1];
		}else if(arr[1][1] == arr[2][1]) {
			answery = arr[0][1];
		}		
		System.out.println(answerx + " "+ answery);	
	}
}
