package solution.levelTest.level11;

import java.util.Scanner;

public class test11_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a = input.nextInt();
		
		System.out.println(new test11_2().fibonacci(a, 0, 1));
		
	}
	int fibonacci(int a, int b, int c) {
		int answer = 0;
		if(a==0) {
			return answer;
		}else if(a==1) {
			answer = 1;
			return answer;
		}
		
		answer = b+c;
		a--;
		if(a!=1) {
			answer = fibonacci(a,c,answer);
		}		
		return answer;
	}
}
