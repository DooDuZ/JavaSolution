package solution.classTest.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class test2164 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 1 ; i<=N; i++) {
			list.add(i);
		}
		
		while(list.size()!=1) {
			list.remove(0);
			list.add(list.get(0));
			list.remove(0);	
		}
		System.out.println(list.get(0));
	}
}
