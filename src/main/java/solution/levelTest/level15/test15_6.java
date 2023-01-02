package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test15_6 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r1 = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i<T-1; i++) {
			int r2 = Integer.parseInt(st.nextToken());
			int commondivisor = commondivisor(r1,r2);			
			sb.append((r1/commondivisor)+"/"+(r2/commondivisor)).append('\n');
		}
		System.out.println(sb);
	}
	
	static public int commondivisor(int a, int b) {
		int rest = a%b;
		a = b;
		b = rest;
		if(rest==0) {
			return a;
		}		
		return commondivisor(a,b);		
	}
}