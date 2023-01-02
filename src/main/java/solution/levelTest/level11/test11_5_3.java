package solution.levelTest.level11;

import java.util.Scanner;

public class test11_5_3 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int k = input.nextInt();
		char[][] arr = new char[k][k];
		
		test11_5_3 test = new test11_5_3();
		
		test.setTree(arr, k);
		
		test.makeblank(arr, k, k/2, k/2);
		
		for(int i = 0; i<k ; i++) {
			for(int j = 0 ; j<k; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	void setTree(char[][] arr, int side) {
		for(int i = 0; i<side; i++) {
			for(int j = 0 ; j<side ; j++) {
				arr[i][j] = '*';								
			}
		}
	}
	
	public void makeblank(char[][] arr, int side, int centerX, int centerY) {
		side /= 3;
		for(int i = centerX-(side/2); i<=centerX+(side/2); i++) {
			for(int j = centerY-(side/2); j<= centerY+(side/2); j++) {
				arr[i][j] = ' ';
			}
		}
		if(side==1) {
			return;
		}
		
		// 1번칸
		makeblank(arr, side, centerX-side, centerY-side);
		// 2번칸
		makeblank(arr, side, centerX, centerY-side);
		// 3번칸
		makeblank(arr, side, centerX+side, centerY-side);
		// 4번칸
		makeblank(arr, side, centerX-side, centerY);
		// 5번 공백
		// 6번 칸
		makeblank(arr, side, centerX+side, centerY);
		// 7번 칸
		makeblank(arr, side, centerX-side, centerY+side);
		// 8번 칸
		makeblank(arr, side, centerX, centerY+side);
		// 9번 칸
		makeblank(arr, side, centerX+side, centerY+side);
	}
}
/*
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	***   ******   ******   ***
	* *   * ** *   * ** *   * *
	***   ******   ******   ***
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	*********         *********
	* ** ** *         * ** ** *
	*********         *********
	***   ***         ***   ***
	* *   * *         * *   * *
	***   ***         ***   ***
	*********         *********
	* ** ** *         * ** ** *
	*********         *********
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	***   ******   ******   ***
	* *   * ** *   * ** *   * *
	***   ******   ******   ***
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
*/