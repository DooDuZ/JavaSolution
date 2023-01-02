package solution.levelTest.level8;

import java.util.Scanner;

public class test8_3 {
	// 백준 홈페이지 채점이 멈췄다.
	// 오늘은 여기까지
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		for(int i = 2 ; i<=n ; i++) {
			while(n%i==0) {
				n = n/i;
				System.out.println(i);
			}
		}
	}
}