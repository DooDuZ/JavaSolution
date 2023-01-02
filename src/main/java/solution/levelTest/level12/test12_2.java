package solution.levelTest.level12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class test12_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N<10) {
			System.out.println(N);
			return;
		}
		for(int i = 0 ; i<N; i++) {
			String n = String.valueOf(i);
			int sum = i;
			for(int j = 0; j<n.length(); j++) {
				sum += n.charAt(j)-'0';
			}
			if(sum==N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}