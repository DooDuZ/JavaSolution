package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1074 {
	
	static int count = 0;
	static int row;
	static int col;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		checkQuadrant(N,row,col);

		System.out.println(count-1);
	}
	
	public static void checkQuadrant(int N, int r, int c) {
		if(N==1) {
			if(r==1) {
				count += 2;
			}
			count += c+1;
			return;
		}
		int flag = (int) Math.pow(2, N-1);
		if(r<flag && c<flag) {
			count += 0;
		}else if(r<flag && c>=flag) {
			count += flag*flag;
			col-=flag;
		}else if(r>=flag && c<flag) {
			count += flag*flag*2;
			row-=flag;
		}else if(r>=flag && c>=flag) {
			count += flag*flag*3;
			row-=flag;
			col-=flag;
		}
		checkQuadrant(N-1,row,col);
	}	
}
