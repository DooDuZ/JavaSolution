package solution.levelTest.level14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test14_7 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int k = 0; k<T; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int goalX = Integer.parseInt(st.nextToken());
			int goalY = Integer.parseInt(st.nextToken());
			
			st = null;
			
			int p = Integer.parseInt(br.readLine());
			
			int count=0;
					
			for(int i = 0 ; i<p; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				boolean check = false;
				
				if(((startX-x)*(startX-x) + (startY-y)*(startY-y)) <= r*r) {
					check = !check;
				}
				
				if(((goalX-x)*(goalX-x) + (goalY-y)*(goalY-y)) <= r*r) {
					check = !check;
				}
				
				if(check) {
					count++;
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
}

/*
 	2
	-5 1 12 1
	7
	1 1 8
	-3 -1 1
	2 2 2
	5 5 1
	-4 5 1
	12 1 1
	12 1 2
	-5 1 5 1
	1
	0 0 2
*/
