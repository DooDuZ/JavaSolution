package solution.levelTest.level14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test14_6_2 {

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
			
			double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
			
			// 동일원 -> return -1
			
			if(distance == 0 && r1==r2) {
				System.out.println(-1);
				continue;
			}
			
			// 외부/거리초과 return 0
			if(distance > r1+r2) {
				System.out.println(0);
				continue;
			}

			// 포함 원 return 0 
			if(distance<r1 && r1-distance>r2) {				
				System.out.println(0);
				continue;
			}
			if(distance<r2 && r2-distance>r1) {				
				System.out.println(0);
				continue;
			}
			
			// 내접 return 1
			if(distance<r1 && r1-distance==r2) {				
				System.out.println(1);
				continue;
			}
			if(distance<r2 && r2-distance==r1) {				
				System.out.println(1);
				continue;
			}
			
			// 외접 return 1
			if(distance == r1+r2) {
				System.out.println(1);
				continue;
			}			
			System.out.println(2);	
		}		
	}	
}

/*
	3
	0 0 13 40 0 37
	0 0 3 0 7 4
	1 1 1 1 1 5

*/
