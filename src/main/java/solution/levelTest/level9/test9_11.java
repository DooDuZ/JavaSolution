package solution.levelTest.level9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class test9_11 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		String[][] list = new String[T][3];
		
		StringTokenizer st;
		for(int i = 0 ; i<T ; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list[i][0] = String.valueOf(age);
			list[i][1] = name;
			list[i][2] = String.valueOf(i);
		}
		
		Arrays.sort(list, (e1,e2)->{
			if( e1[0].equals(e2[0]) ) {
				return Integer.parseInt(e1[2])-Integer.parseInt(e2[2]);
			}else {
				return Integer.parseInt(e1[0])-Integer.parseInt(e2[0]);				
			}
		});
		
		for(int i = 0 ; i<T ; i++) {
			sb.append(list[i][0]+" ").append(list[i][1]+"\n");
		}
		System.out.println(sb);
	}
}
