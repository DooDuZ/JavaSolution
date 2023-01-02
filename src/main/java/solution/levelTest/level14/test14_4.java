package solution.levelTest.level14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test14_4 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[6][2];
		
		StringTokenizer st;
		for(int i = 0 ; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int width = 0;
		int height = 0;
		
		for(int i = 0 ; i<arr.length; i++) {
			if(arr[i][0]<=2 && arr[i][1]>=width) {
				width = arr[i][1];
			}
			if(arr[i][0]>2 && arr[i][1]>=height) {
				height = arr[i][1];
			}
		}
		
		String str = "";
		for(int i = 0 ; i<6;i++) {
			str += String.valueOf(arr[i][0]);
		}
		for(int i = 0 ; i<3; i++) {
			str += String.valueOf(arr[i][0]);
		}
		
		int a=0;
		int b=0;
		for(int i = 0; i<=str.length()-4; i++) {
			int count = 0;
			if(str.substring(i, i+4).contains("1")) {
				count++;
			}
			if(str.substring(i, i+4).contains("2")) {
				count++;
			}
			if(str.substring(i, i+4).contains("3")) {
				count++;
			}
			if(str.substring(i, i+4).contains("4")) {
				count++;
			}
			if(count==2) {
				a = i+1;
				b = i+2;
				break;
			}
		}
		
		if(a>=6) {
			a -= 6;
		}
		if(b>=6) {
			b -= 6;
		}
		
		int answer = N*(width*height - arr[a][1]*arr[b][1]);
		System.out.println(answer);
	}
}

/*
 	7
	4 50
	2 160
	3 30
	1 60
	3 20
	1 100
	
	1
	1 20
	4 160
	2 50
	3 100
	1 30
	4 60
 */
