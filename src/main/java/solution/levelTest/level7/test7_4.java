package solution.levelTest.level7;

import java.util.Scanner;

public class test7_4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		for(int i = 1; i<=T ; i++) {
			int H = input.nextInt();
			int W = input.nextInt();
			int N = input.nextInt();
			
			int floor = N%H;
			if(N%H==0) {
				floor = H;
			}
			int room = (N/H);
			if(N%H!=0) {
				room++;
			}
			if(room<10) {
				System.out.println(floor*100+room);
			}else {
				System.out.println(floor*100+room);
			}
		}	
	}
}
