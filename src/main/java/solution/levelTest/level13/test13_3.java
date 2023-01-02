package solution.levelTest.level13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class test13_3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = null;
		
		Map<String, String> map = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		
		for(int i = 0 ; i<N ; i++) {
			String str = br.readLine();
			map.put(String.valueOf(i+1), str);
			map.put(str, String.valueOf(i+1));
		}
		
		for(int i = 0 ; i<M ; i++) {
			String key = br.readLine();
			if(map.containsKey(key)) {
				sb.append(map.get(key)).append('\n');
			}else {
				sb.append(map2.get(key)).append('\n');
			}
		}
		System.out.println(sb);
	}
}
