package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test9095 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i<T; i++) {
			sb.append(cases(Integer.parseInt(br.readLine()))).append('\n');
		}
		System.out.println(sb);
	}
	
	public static int cases(int a) {
		int count=0;
		
		
		
		return count;
	}
}

