package solution.classTest.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2577 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		String str = String.valueOf( (a*b*c) );
		
		int[] arr = new int[10];
		
		for(int i = 0; i<str.length(); i++) {
			arr[str.charAt(i)-48]++;
		}
		
		for(int tmp : arr) {
			System.out.println(tmp);
		}		
	}
}
