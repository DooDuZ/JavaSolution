package solution.levelTest.level8;

import java.util.Scanner;

public class test8_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		int answer = 0;
		
		for(int i = 0 ; i<T ; i++) {
			int n = input.nextInt();
			int count = 0;
			for(int j = 1; j<=n ; j++) {
				if(n%j==0) {
					count++;
				}
			}
			if(count == 2) {
				answer++;
			}			
		}
		System.out.println(answer);
	}	
}