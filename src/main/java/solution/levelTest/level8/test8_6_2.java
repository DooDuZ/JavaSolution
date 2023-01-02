package solution.levelTest.level8;

import java.util.Scanner;

public class test8_6_2 {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		// long sTime = System.currentTimeMillis(); - 시간측정 시작
		int[] prime = new int[1];
		
		prime[0] = 2;
		int count = 1;
		for(int i = 3 ; i<10000 ; i++) {
			boolean checkPrime = true;
			int[] primeNum;
			for(int j = 2 ; j<=Math.pow(i, 0.5) ; j++) {
				if(i%j==0) {
					checkPrime = false;
					break;
				}
			}
			if(checkPrime) {
				primeNum = prime;
				count++;
				prime = new int[count];
				for(int k = 0 ; k<count-1 ; k++) {
					prime[k] = primeNum[k];
				}
				prime[count-1] = i;				
			}
		}
		
		/*
		 	계산해보면 0.004초 나온다...
		 	1~10000까지 소수의 배열을 만드는 건 소수가 발견될 때마다 새로운 배열을 생성하더라도 정말 찰나다.
		 	
			long eTime = System.currentTimeMillis();
			long aTime = eTime-sTime;
			System.out.println((double)aTime/1000);
		*/
		
		for(int i = 0 ; i<T ; i++) {
			int a = input.nextInt();
			
			int x;
			int y;
			
			for(int j = 0 ; j<=prime.length/2 ; j++) {
				boolean check;
				for(int k = j ; k<prime.length ; k++) {
					
				}
			}
			
		}
	}
}
