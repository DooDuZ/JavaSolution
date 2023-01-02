package solution.levelTest.level13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class test13_6 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i<N; i++) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<M; i++) {
			int el = Integer.parseInt(st.nextToken());
			if(map.containsKey(el)) {
				map.put(el, 2);
			}else {
				map.put(el, 1);
			}
		}
		
		int count = 0;
		
		for(int num : map.keySet()) {
			if(map.get(num)==1) {
				count++;
			}
		}		
		System.out.println(count);
	}
}
