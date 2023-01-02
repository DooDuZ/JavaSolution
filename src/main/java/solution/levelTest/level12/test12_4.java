package solution.levelTest.level12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test12_4 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int rows = Integer.parseInt(st.nextToken());
		int cols = Integer.parseInt(st.nextToken());		
		char[][] arr = new char[rows][cols];
		
		char[][] pattern1 = new char[8][8];
		char[][] pattern2 = new char[8][8];
		
		for(int i = 0 ; i<8 ;i++) {
			for(int j=0; j<8; j++) {
				if(i%2==0) {
					if(j%2==0) {
						pattern1[i][j] = 'B';
						pattern2[i][j] = 'W';
					}else {
						pattern1[i][j] = 'W';
						pattern2[i][j] = 'B';
					}
				}else {
					if(j%2==0) {
						pattern1[i][j] = 'W';
						pattern2[i][j] = 'B';
					}else {
						pattern1[i][j] = 'B';
						pattern2[i][j] = 'W';
					}
				}
			}
		}

		st = null;
		for(int i = 0 ; i<rows ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j<cols; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int min = 32;
		for(int i = 0; i<=rows-8; i++) {
			for(int j = 0; j<=cols-8; j++) {
				int count1 = 0;
				int count2 = 0;
				for(int k = 0 ; k<8; k++) {
					for(int l = 0 ; l<8 ; l++) {
						if(arr[i+k][j+l]!=pattern1[k][l]) {
							count1++;
						}
						if(arr[i+k][j+l]!=pattern2[k][l]) {
							count2++;
						}
					}
				}
				if(count1>count2 && count2<min) {
					min = count2;
				}else if(count1<count2 && count1<min){
					min = count1;
				}
			}
		}
		System.out.println(min);			
	}
}

/*
	10 13
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB
*/
