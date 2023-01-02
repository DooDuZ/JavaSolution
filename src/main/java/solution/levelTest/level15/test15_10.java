package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class test15_10 {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 0 ; i<T; i++) {
			
			Map<String, Integer> map = new HashMap<>();
			
			int answer = 1;
			
			int n = Integer.parseInt(br.readLine());
			
			for(int j = 0 ; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				String cloth = st.nextToken();
				String type = st.nextToken();
				if(map.containsKey(type)) {
					map.put(type, map.get(type)+1);
				}else {
					map.put(type, 2);
				}
			}
			
			if(n == 0) {
				System.out.println(0);
				continue;
			}
			
			for(String wear : map.keySet()) {
				answer *= map.get(wear);
			}
			
			System.out.println(answer-1);			
		}
	}	
}
