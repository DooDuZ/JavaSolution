package solution.levelTest.level7;

import java.util.Scanner;

public class test7_7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("설탕");
		int N = input.nextInt();
		
		if( /*N==0 || N==1 || N==2 || */ N==4 || N==7) {
			System.out.println(-1);
		}		
		else if(N%5==0) {
			System.out.println(N/5);
		}else if(N%5==4 || N%5==2) {
			System.out.println((N/5)+2);
		}else if(N%5==3 || N%5==1) {
			if(N==3) {
				System.out.println(1);
			}else {
				System.out.println((N/5)+1);
			}
		}
	}
}
