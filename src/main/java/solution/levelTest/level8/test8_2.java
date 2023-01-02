package solution.levelTest.level8;

import java.util.Scanner;

public class test8_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a = input.nextInt();
		int b = input.nextInt();
		
		int[] answer_box = new int[b-a+1];
		// a==b 이면 배열 길이가 0이되면서 런타임 에러 발생
		// a==b인 경우 -1출력 후 return하면 오답처리함
		// 백준 병신 ㅋㅋ
		// 결국 배열 길이 +1 해주면, 배열 길이를 쓰거나 하지않으므로 무방함
		int answerCount = 0;		
		
		for(int i = a ; i<=b ; i++) {
			int count = 0;
			for(int j = 1 ; j<=i ; j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count==2) {
				answer_box[i-a] = i;
				answerCount++;
			}
		}
		
		for(int tmp : answer_box) {
			if(tmp!=0) {
				System.out.print(tmp + " ");
			}
		}
		System.out.println("");
		if(answerCount>0) {
			int sum = 0;
			int firstNum = 0;
			for(int i = 0 ; i<answer_box.length ; i++) {
				sum += answer_box[i];
				if(answer_box[i]!=0 && firstNum==0) {
					firstNum = answer_box[i];
				}
			}
			System.out.println(sum);
			System.out.println(firstNum);
		}else if(answerCount==0) {
			System.out.println(-1);
		}		
	}	
}
