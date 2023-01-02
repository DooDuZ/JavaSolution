package solution.levelTest.level8;

import java.util.Scanner;

public class test8_5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true) {
			try {
				int n = input.nextInt();
				
				boolean[] prime = new boolean[2*n+1];
				
				prime[0] = true;
				prime[1] = true;
				
				for(int i=2 ; i<=Math.pow(2*n, 0.5) ; i++) {
					if(prime[i]) {
						continue;
					}
					for(int j = i*i ; j<2*n+1 ; j+=i) {
						prime[j] = true;
					}
				}
				int count = 0;
				for(int i = n+1 ; i<2*n+1 ; i++) {
					if(!prime[i]) {
						count ++;
					}
				}
				System.out.println(count);				
			} catch (Exception e) {
				break;
			}
		}		
	}
}
