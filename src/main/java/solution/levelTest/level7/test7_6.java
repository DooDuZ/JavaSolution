package solution.levelTest.level7;

import java.util.Scanner;

public class test7_6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int[][] apart = new int[15][14];
		System.out.print("반복 횟수");
		int T = input.nextInt();
		 	for(int i = 0 ; i< 15 ; i++){
				for(int j = 0 ; j<14 ; j++){
					int sum = 0 ;
					if(i==0){
						sum = j+1 ;
						apart[i][j] = sum;
					}else if(j==0){
						sum = 1;
						apart[i][j] = sum;
					}else{
						sum = (apart[i-1][j]+apart[i][j-1]);
						apart[i][j] = sum;
					}
				}
			}
		for(int i = 1; i<=T ; i++) {
			System.out.println("아파트 층수");
			int k = input.nextInt();
			System.out.println("아파트 호수");
			int n = input.nextInt();
			System.out.println(apart[k][n-1]);			
		}
	}
}
