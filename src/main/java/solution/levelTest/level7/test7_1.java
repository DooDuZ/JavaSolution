package solution.levelTest.level7;

import java.util.Scanner;

public class test7_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int A = input.nextInt();
		int B = input.nextInt();
		int C = input.nextInt();
		
		if(C<=B) {
			System.out.println(-1);
		}else {
			System.out.println(A/(C-B)+1);
			/*
			 	백준 ㄹㅇ 개 병신새끼들아...
			 	A/(C-B)+1 은  (A/(C-B)+1) 이랑 연산이 다를 수가 없어요.. .씨@빨년들아!!!!! 
			 	내 한시간 돌려내
			*/
		}
	}
}
