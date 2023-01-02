package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test11723 {
	static ArrayList<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 0 ; i<T ; i ++) {
			st = new StringTokenizer(br.readLine());

			String method = st.nextToken();
			
			if(method.equals("all")) {
				all();
				continue;
			}else if(method.equals("empty")) {
				empty();
				continue;
			}	
			
			int param = Integer.parseInt(st.nextToken());
			
			if(method.equals("add")) {
				add(param);
			}else if(method.equals("remove")) {
				remove(param);
			}else if(method.equals("check")) {
				check(param);
			}else if(method.equals("toggle")) {
				toggle(param);
			}	
		}
		System.out.println(sb);		
	}
	public static void all() {
		list.clear();
		for(int i = 1 ; i<=20; i++) {
			list.add(i);
		}
	}
	
	public static void add(int x) {
		if(!list.contains(x)) {
			list.add(x);
		}
	}
	
	public static void remove(int x) {
		if(list.contains(x)) {
			list.remove(list.indexOf(x));
		}
	}
	
	public static void check(int x) {
		if(list.contains(x)) {
			sb.append(1).append('\n');
		}else {
			sb.append(0).append('\n');
		}
	}
	
	public static void toggle(int x) {
		if(!list.contains(x)) {
			list.add(x);
		}else {
			list.remove(list.indexOf(x));
		}
	}
	
	public static void empty() {
		list.clear();
	}	
}
