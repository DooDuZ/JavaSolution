package solution.levelTest.level11;

import java.util.Scanner;

public class test11_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a = input.nextInt();
		
		test11_1 test = new test11_1();
		
		System.out.println(test.factorial(1, a));		
	}
	int factorial(int b, int a) {
		int answer = 1;
		if(a==0 || a==1) {
			return answer;
		}		
		answer = b*a;
		
		a--;
		if(a!=1) {
			answer = factorial(answer,a);
		}
		return answer;
	}
}
