package solution.levelTest.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test16_6_1 {
	static int count = 0;
	static int[][] arr = new int[9][9];
	static int zeroes=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0 ; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for( int j = 0 ; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) {
					zeroes++;
				}
			}
		}		
		dfsSudoku(0);
	}
	
	public static void dfsSudoku(int depth) {		
		if(depth==zeroes) {
			for(int i = 0 ; i<9; i++) {
				for( int j = 0 ; j<9; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);			
			System.exit(0);
			return;
		}
		for(int i = 0 ; i<9; i++) {
			for(int j = 0 ; j<9; j++) {
				count++;
				if(arr[i][j]==0) {
					// if(checkBox( value ,i,j))
					// arr[i][j] = value;
					// dfsSudoku(depth+1);
					
					// 재귀 끝나면 
					// arr[i][j] = 0;
					
					for(int k = 1; k<=9; k++) {
						if(checkBox(k,i,j)) {
							arr[i][j] = k;
							dfsSudoku(depth+1);
							arr[i][j] = 0;
						}
					}
				}
			}
		}
	}
	
	public static boolean checkBox(int value, int row, int col) {
		// 가로		
		for(int i=0; i<9; i++) {
			if(arr[row][i] == value) {
				return false;				
			}
		}
		// 세로		
		for(int i=0; i<9; i++) {
			if(arr[i][col] == value) {
				return false;
			}
		}
		// 같은 블록
		for(int i = row/3*3 ; i<row/3*3+3; i++) {
			for(int j = col/3*3; j<col/3*3+3; j++) {
				if(arr[i][j]==value) {
					return false;
				}
			}
		}
		return true;
	}
}

/*

1 3 5 4 6 9 2 7 8 
7 8 2 1 0 5 6 0 9 
4 6 9 2 7 8 1 3 5 
3 2 1 5 4 6 8 9 7 
8 0 4 9 1 3 5 0 6 
5 9 6 8 2 7 4 1 3 
9 1 7 6 5 2 3 8 0 
6 0 3 7 8 1 9 5 2 
2 5 8 3 9 4 7 6 0 


0 0 0 0 0 0 0 0 9
0 0 0 0 0 0 0 0 8
0 0 0 0 0 0 0 0 7
0 0 0 0 0 0 0 0 6
0 0 0 0 0 0 0 0 5
0 0 0 0 0 0 0 0 4
0 0 0 0 0 0 0 0 3
0 0 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0 1


*/