package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class test15_4 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i = 0 ; i<T ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int answer = a*b;
			
			int maxDivisor=1;
			while(true) {
				int r = a%b;
				
				a = b;
				b = r;
				
				if(r==0) {
					maxDivisor = a;
					break;
				}
			}			
			sb.append(answer/maxDivisor).append('\n');
		}		
		System.out.println(sb);
	}
}
