package solution.levelTest.level13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class test13_4 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(map.containsKey(a)) {
				map.put(a, map.get(a)+1);
			}else {
				map.put(a, 1);
			}
		}
		st = null;
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M ; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(map.containsKey(a)) {
				sb.append(map.get(a)).append(' ');
			}else {
				sb.append(0).append(' ');
			}
		}
		System.out.println(sb);		
	}
}

/*
 	10
	6 3 2 10 10 10 -10 -10 7 3
	8
	10 9 -5 2 3 4 5 -10
*/
