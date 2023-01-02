package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test1874 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int count = 0;
		boolean check = true;
		
		for(int i = 0 ; i<n; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if(count<a) {
				for(int j = count+1 ; j<=a; j++) {
					list.add(j);
					sb.append("+").append('\n');
					count++;
				}
			}
			
			if(list.get(list.size()-1)!=a) {
				check = false;
			}
			list.remove(list.size()-1);
			sb.append("-").append('\n');
		}
		if(check) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
		
	}
}
/*
	8
	4
	3
	6
	8
	7
	5
	2
	1

	5
	1
	2
	5
	3
	4
*/