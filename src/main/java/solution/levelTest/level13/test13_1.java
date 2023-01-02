package solution.levelTest.level13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.IOException;

public class test13_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N ; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		st = null;
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<M; i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) {
				sb.append(1).append(' ');
			}else {
				sb.append(0).append(' ');
			}
		}
		System.out.println(sb);		
	}
}
/*
	5
	6 3 2 10 -10
	8
	10 9 -5 2 3 4 5 -10
*/