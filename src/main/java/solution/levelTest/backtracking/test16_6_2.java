package solution.levelTest.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test16_6_2 {
	static int count = 0;
	static int[][] arr = new int[9][9];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0 ; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for( int j = 0 ; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfsSudoku(0,0);
	}
	
	public static void dfsSudoku(int row, int col) {		
		if(col==9) {
			dfsSudoku(row+1,0);
			return;
		}
		if(row==9) {
			for(int i = 0 ; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if(arr[row][col]==0) {
			for(int i = 1; i<=9; i++) {
				if(checkBox(i, row, col)) {
					arr[row][col] = i;
					dfsSudoku( row, col+1 );
				}
			}
			arr[row][col] = 0;
			return;
		}
		dfsSudoku( row, col+1 );
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