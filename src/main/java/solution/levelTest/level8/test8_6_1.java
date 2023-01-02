package solution.levelTest.level8;

import java.util.Scanner;

public class test8_6_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
				
		int[] primeNumber = new int[1]; 

		primeNumber[0] = 2;
		
		int length = 1;
		for(int j = 0 ; j<=10000 ; j++) {
			if(j<=1) {
				continue;
			}
			boolean check = true;
			for(int i = 0 ; i<length ; i++) {
				if(j%primeNumber[i]==0) {
					if(!check) {
						break;
					}
					check = false;
				}
			}
			if(check) {
				int[] storage = new int [length];
				length++;
				storage = primeNumber;
				primeNumber = new int[length];
				for(int k = 0 ; k<length-1 ; k++) {
					primeNumber[k] = storage[k];
				}
				primeNumber[length-1] = j;
			}
		}
		
		int T = input.nextInt();
		for(int i = 0 ; i<T ; i++) {
			int a = input.nextInt();
			
			int x = 0;
			int y = 10000 ;
			
			for(int j = 0 ; j<=primeNumber.length/2 ; j++) {
				for(int k = j ; k<primeNumber.length ; k++) {
					if((primeNumber[j]+primeNumber[k])==a && (primeNumber[k]-primeNumber[j]) < y-x) {
						x = primeNumber[j];
						y = primeNumber[k];
					}
				}
			}			
			System.out.println(x+" "+y);
		}		
	}
}