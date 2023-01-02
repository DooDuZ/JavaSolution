package solution.levelTest.level13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class test13_5 {
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
		int count=0;
		for(int i = 0 ; i<M; i++) {
			String name = br.readLine();
			if(map.containsKey(name)) {
				map.put(name, map.get(name)+1);
				count++;
			}else {
				map.put(name,1);				
			}
		}
		
		String[] arr = new String[count];
		
		int index = 0;
		for(String s : map.keySet()) {
			if(map.get(s)==2) {
				arr[index] = s;
				index++;
			}
		}

		Arrays.sort(arr, (el, el2)->{
			if(el.length()==el2.length()) {
				for(int i = 0; i<el.length(); i++) {
					if(el.charAt(i)!=el2.charAt(i)) {
						return el.charAt(i)-el2.charAt(i);
					}
				}
			}else {
				int min;
				if(el.length()>el2.length()) {
					min = el2.length();
				}else {
					min = el.length();
				}
				for(int i = 0 ; i<min; i++) {
					if(el.charAt(i)!=el2.charAt(i)) {
						return el.charAt(i)-el2.charAt(i);
					}
				}
			}
			return el.length() - el2.length();	
		});
		
		sb.append(count).append('\n');
		
		for(int i = 0; i<arr.length; i++) {
			sb.append(arr[i]).append('\n');
		}
		System.out.println(sb);	
	}
}



/*
	ohhenrie
	charlie
	baesangwook
	obama
	baesangwook
	ohhenrie
	clinton
*/