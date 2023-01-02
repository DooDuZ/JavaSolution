package solution.levelTest.level14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


public class test14_6_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 0 ; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int X = (x1-x2);
			int Y = (y1-y2);

			int distance = X*X + Y*Y;
			
			if(distance==0) {
				if(r1==r2) {
					System.out.println(-1);
				}else if(r1!=r2) {
					System.out.println(0);
				}
			}else if(distance<=r1*r1) {
				if(r1-distance < r2*r2) {
					System.out.println(2);
				}else if(r1-distance == r2*r2) {
					System.out.println(1);
				}else if(r1-distance > r2*r2) {
					System.out.println(0);
				}				
			}else if(distance<=r2*r2) {
				if(r2-distance < r1*r1) {
					System.out.println(2);
				}else if(r2-distance == r1*r1) {
					System.out.println(1);
				}else if(r2-distance > r1*r1) {
					System.out.println(0);
				}
			}else{
				if((r1+r2)*(r1+r2) == distance) {
					System.out.println(1);
				}else if((r1+r2)*(r1+r2) <distance){
					System.out.println(0);
				}else {
					System.out.println(2);
				}
			}
		}		
	}
}
/*
 	3
	0 0 13 40 0 37
	0 0 3 0 7 4
	1 1 1 1 1 5
 	
 	
 	1
	0 0 3 1 0 1
	1.0
	2
*/