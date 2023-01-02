package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test15829 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		
		String toHash = br.readLine();
		
		int sum = 0;
		
		for(int i = 0 ; i<L; i++) {
			int a = toHash.charAt(i)-96;
			int r = 1234567891;
			sum += ( (a % r) * (Math.pow(31, i) % r) );			
		}
		System.out.println(sum);
	}
}