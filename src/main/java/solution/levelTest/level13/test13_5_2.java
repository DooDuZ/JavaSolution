package solution.levelTest.level13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class test13_5_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		st = null;
		
		for(int i = 0 ; i<N; i++) {
			String name = br.readLine();
			if(map.containsKey(name)) {
				map.put(name, map.get(name)+1);
			}else {
				map.put(name,1);
			}			
		}
		for(int i = 0 ; i<M; i++) {
			String name = br.readLine();
			if(map.containsKey(name)) {
				map.put(name, map.get(name)+1);
			}else {
				map.put(name,1);				
			}
		}
        
		ArrayList<String> list = new ArrayList<>();
		for(String s : map.keySet()) {
			if(map.get(s)==2) {
				list.add(s);
			}
		}
		Collections.sort(list);
		sb.append(list.size()).append('\n');
		for(int i = 0 ; i<list.size(); i++) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.println(sb);
	}
}

/*
	3 4
	ohhenrie
	charlie
	baesangwook
	obama
	baesangwook
	ohhenrie
	clinton

*/
