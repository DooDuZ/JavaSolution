package solution.levelTest.level9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class test9_6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		char[] arr = s.toCharArray();
		
		Arrays.sort(arr);
		
		for(int i = arr.length-1 ; i>=0 ; i--) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
