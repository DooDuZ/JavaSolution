package solution.levelTest.level13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.IOException;

public class test13_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		
		st = null;
		for( int i = 0 ; i<N ; i++) {
			set.add(br.readLine());
		}
		int count = 0;
		for(int i = 0; i<M; i++) {
			if( set.contains(br.readLine()) ) {
				count++;
			}
		}
		System.out.println(count);
	}
}
