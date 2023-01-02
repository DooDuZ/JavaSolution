package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class test15_11_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for(int i = 1 ; i<=N; i++) {
			if(i%5==0) {
				count++;
			}
			if(i%25==0) {
				count++;
			}
			if(i%125==0) {
				count++;
			}
		}		
		System.out.println(count);
	}
}
