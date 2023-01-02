package solution.levelTest.level13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.io.IOException;

public class test13_7 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		Set<String> set = new HashSet<>();
		
		for(int i = 1; i<=s.length(); i++) {
			String str = "";
			for(int j = 0 ; j<=s.length()-i; j++) {
				str = s.substring(j, j+i);
				set.add(str);
			}			
		}		
		System.out.println(set.size());
	}
}
