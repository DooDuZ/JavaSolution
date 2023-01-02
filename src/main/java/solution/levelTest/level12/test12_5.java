package solution.levelTest.level12;

import java.util.Scanner;

public class test12_5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		int count = 0;
		int i = 0;
		while(count!=N) {
			i++;
			if(String.valueOf(i).contains("666")) {
				count++;
			}
		}		
		System.out.println(i);		
	}
}
